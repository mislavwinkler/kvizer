package hr.tvz.winkler.kvizer.quiz;

import java.util.List;
import java.util.Optional;

public interface QuizServiceInterface {

    List<QuizDTO> findAll();

    List<QuizDTO> findAllByMaker(String username);

    Optional<QuizDTO> findByCode(final String code);

    Optional<QuizDTO> save(final QuizCommand quizCommand);

    void delete(String code);

    Optional<QuizDTO> update(final String code, final QuizCommand quizCommand);

}
