package hr.tvz.winkler.kvizer;

import hr.tvz.winkler.kvizer.security.repository.UserRepository;
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
public class QuizRepository implements QuizRepositoryInterface{

    private static final String SELECT_ALL = "SELECT id, code, name, maker_id, creation_date FROM quiz";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;
    private final UserRepository userRepository;

    public QuizRepository(JdbcTemplate jdbc, UserRepository userRepository) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("quiz")
                .usingGeneratedKeyColumns("id");
        this.userRepository = userRepository;
    }

    @Override
    public List<Quiz> findAll() {
        return List.copyOf(jdbc.query(SELECT_ALL, this::mapRowToQuiz));
    }

    @Override
    public Optional<Quiz> findByCode(String code) {
        try{
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE code = ?", this::mapRowToQuiz, code)
            );
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<Quiz> save(Quiz quiz) {
        try {
            saveQuizDetails(quiz);
            return Optional.of(quiz);
        } catch (DuplicateKeyException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<Quiz> update(String code, Quiz updatedQuiz) {
        int executed = jdbc.update("UPDATE quiz set " +
                        "name = ?, " +
                        "maker_id = ?, " +
                        "WHERE code = ?",
                updatedQuiz.getName(),
                updatedQuiz.getMaker().getId(),
                updatedQuiz.getCode()
        );

        if(executed > 0){
            return Optional.of(updatedQuiz);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(String code) {
        jdbc.update("DELETE FROM hardware WHERE code = ?", code);
    }

    private Quiz mapRowToQuiz(ResultSet rs, int rowNum) throws SQLException {
        return new Quiz(
                rs.getInt("id"),
                rs.getString("code"),
                rs.getString("name"),
                userRepository.findById(rs.getLong("maker_id")).orElse(null),
                rs.getDate("creation_date")
        );
    }

    private String saveQuizDetails(Quiz quiz) {
        Map<String, Object> values = new HashMap<>();

        values.put("code", quiz.getCode());
        values.put("name", quiz.getName());
        values.put("maker_id", quiz.getMaker().getId());
        values.put("creation_date", quiz.getCreationDate());

        return inserter.executeAndReturnKey(values).toString();
    }

    @Override
    public List<Quiz> search(String searchText) {
        {
            return List.copyOf(jdbc.query(SELECT_ALL + " WHERE code LIKE ?%", this::mapRowToQuiz, searchText));
        }
    }
}
