package hr.tvz.winkler.kvizer;

import java.util.List;
import java.util.Optional;

public interface QuizRepositoryInterface {

    List<Quiz> findAll();

    Optional<Quiz> findByCode(String code);

    Optional<Quiz> save(Quiz quiz);

    void delete(String code);

    Optional<Quiz> update(String code, Quiz quiz);

    List<Quiz> search(String searchText);
}
