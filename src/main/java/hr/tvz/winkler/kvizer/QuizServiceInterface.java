package hr.tvz.winkler.kvizer;

import java.util.List;
import java.util.Optional;

public interface QuizServiceInterface {

    List<QuizDTO> findAll();

    Optional<QuizDTO> findByCode(final String code);

    Optional<QuizDTO> save(final QuizCommand quizCommand);

    void delete(String code);

    Optional<QuizDTO> update(final String code, final QuizCommand quizCommand);

}
