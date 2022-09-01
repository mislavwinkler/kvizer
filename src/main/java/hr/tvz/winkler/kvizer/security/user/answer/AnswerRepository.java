package hr.tvz.winkler.kvizer.security.user.answer;


import hr.tvz.winkler.kvizer.question.QuestionRepository;
import hr.tvz.winkler.kvizer.security.domain.User;
import hr.tvz.winkler.kvizer.security.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class AnswerRepository implements AnswerRepositoryInterface {

    private static final String SELECT_ALL = "SELECT * FROM answer";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;
    private final QuestionRepository questionRepository;
    private final UserRepositoryImpl userRepository;

    public AnswerRepository(JdbcTemplate jdbc, QuestionRepository questionRepository, UserRepositoryImpl userRepository) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("answer")
                .usingGeneratedKeyColumns("id");
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Answer> findAll() {
        return List.copyOf(jdbc.query(SELECT_ALL, this::mapRowToAnswer));
    }

    @Override
    public List<User> findAllUsersThatAnsweredByQuizCode(String code){
        return List.copyOf(jdbc.query("SELECT DISTINCT users.* FROM answer " +
                        "LEFT JOIN question ON question.id = answer.question_id " +
                        "LEFT JOIN quiz ON question.quiz_id = quiz.id " +
                        "LEFT JOIN users ON answer.user_id = users.id " +
                        "WHERE quiz.code = ?",
                 this::mapRowToUser, code));
    }

    @Override
    public Optional<Answer> findById(Long id) {
        try{
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE id = ?", this::mapRowToAnswer, id)
            );
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }


    @Override
    public List<Answer> findAnswersByQuestionId(Long questionId) {
        return List.copyOf(jdbc.query(SELECT_ALL +
                        " LEFT JOIN question ON answer.question_id = question.id " +
                        "WHERE question.id = ?",
                        this::mapRowToAnswer, questionId));
    }

    @Override
    public List<Answer> findAnswersByQuizCodeAndUsername(String quizCode, String userName) {
        return List.copyOf(jdbc.query(SELECT_ALL +
                        " LEFT JOIN users ON answer.user_id = users.id " +
                        "LEFT JOIN question ON answer.question_id = question.id " +
                        "LEFT JOIN quiz ON question.quiz_id = quiz.id " +
                        "WHERE users.username = ? AND quiz.code = ? "+
                        "ORDER BY question.position",
                this::mapRowToAnswer, userName, quizCode));
    }

    @Override
    public Optional<Answer> save(Answer answer) {
        try {
            saveAnswerDetails(answer);
            return Optional.of(answer);
        } catch (DuplicateKeyException e){
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        jdbc.update("DELETE answer FROM answer " +
                "WHERE id = ?", id);
    }

    @Override
    public Optional<Answer> update(Long id, Answer updatedAnswer) {
        int executed = jdbc.update("UPDATE answer " +
                        "SET answer.answer = ?, " +
                        "answer.question_id = ?, " +
                        "answer.user_id = ?" +
                        "WHERE answer.id = ?",
                updatedAnswer.getAnswer(),
                updatedAnswer.getQuestion().getId(),
                updatedAnswer.getUser().getId(),
                id
                );

        if(executed > 0){
            return Optional.of(updatedAnswer);
        } else {
            return Optional.empty();
        }
    }

    private Answer mapRowToAnswer(ResultSet rs, int rowNum) throws SQLException {
        return new Answer(
                rs.getLong("id"),
                rs.getString("answer"),
                questionRepository.findById(rs.getLong("question_id")).get(),
                userRepository.findById(rs.getLong("user_id")).get()
        );
    }

    private User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email")
        );
    }

    private String saveAnswerDetails(Answer answer) {
        Map<String, Object> values = new HashMap<>();

        values.put("answer", answer.getAnswer());
        values.put("question_id", answer.getQuestion().getId());
        values.put("user_id", answer.getUser().getId());

        return inserter.executeAndReturnKey(values).toString();
    }
}
