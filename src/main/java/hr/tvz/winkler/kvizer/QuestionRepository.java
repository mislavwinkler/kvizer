package hr.tvz.winkler.kvizer;


import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class QuestionRepository implements QuestionRepositoryInterface{

    private static final String SELECT_ALL = "SELECT question.id, position, question, answer FROM question";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    public QuestionRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("question")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Question> findAll() {
        return List.copyOf(jdbc.query(SELECT_ALL, this::mapRowToQuestion));
    }

    @Override
    public Optional<Question> findById(Long id) {
        try{
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE id = ?", this::mapRowToQuestion, id)
            );
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }


    @Override
    public List<Question> findQuestionsByQuizCode(String quizCode) {
        return List.copyOf(jdbc.query(SELECT_ALL +
                        " LEFT JOIN quiz_question ON  quiz_question.question_id = question.id " +
                        "LEFT JOIN quiz ON  quiz_question.quiz_id = quiz.id " +
                        "WHERE quiz.code = ?",
                        this::mapRowToQuestion, quizCode));
    }

    @Override
    public Optional<Question> save(Question question) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        jdbc.update("DELETE question FROM question " +
                "WHERE id = ?", id);
    }

    @Override
    public Optional<Question> update(Long id, Question updatedQuestion) {
        int executed = jdbc.update("UPDATE question " +
                        "SET question.position = ?, " +
                        "question.question = ?, " +
                        "question.answer = ?" +
                        "WHERE question.id = ?",
                updatedQuestion.getPosition(),
                updatedQuestion.getQuestion(),
                updatedQuestion.getAnswer(),
                id
                );

        if(executed > 0){
            return Optional.of(updatedQuestion);
        } else {
            return Optional.empty();
        }
    }

    private Question mapRowToQuestion(ResultSet rs, int rowNum) throws SQLException {
        return new Question(
                rs.getLong("id"),
                rs.getLong("position"),
                rs.getString("question"),
                rs.getString("answer")
        );
    }
}
