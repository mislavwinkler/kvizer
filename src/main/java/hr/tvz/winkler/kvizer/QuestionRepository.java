package hr.tvz.winkler.kvizer;


import org.springframework.context.annotation.Primary;
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

    private static final String SELECT_ALL = "SELECT position, question, answer FROM question";

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
    public List<Question> findQuestionsByQuizCode(String quizCode) {
        return null;
    }

    @Override
    public Optional<Question> save(Question question) {
        return Optional.empty();
    }

    @Override
    public void deleteQuestionByQuizCodeAndQuestionPosition(String quizCode, Integer position) {
        jdbc.update("DELETE question FROM question " +
                "LEFT JOIN quiz_question ON  quiz_question.question_id = question.id" +
                "WHERE quiz_question.quiz_id = ? AND question.position = ?", quizCode, position);
    }

    @Override
    public Optional<Question> update(String code, Question question) {
        return Optional.empty();
    }

    private Question mapRowToQuestion(ResultSet rs, int rowNum) throws SQLException {
        return new Question(
                rs.getInt("position"),
                rs.getString("question"),
                rs.getString("answer")
        );
    }
}