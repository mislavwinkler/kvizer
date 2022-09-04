package hr.tvz.winkler.kvizer.quiz;

import java.util.List;
import java.util.Optional;

public interface QuizRepositoryInterface {

    List<Quiz> findAll();

    List<Quiz> findAllByMaker(String makerUsername);

    Optional<Quiz> findById(Long id);

    Optional<Quiz> findByCode(String code);

    Optional<Quiz> save(Quiz quiz);

    void delete(String code);

    Optional<Quiz> update(String code, Quiz quiz);
}
