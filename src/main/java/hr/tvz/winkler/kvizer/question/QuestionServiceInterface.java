package hr.tvz.winkler.kvizer.question;

import java.util.List;
import java.util.Optional;

public interface QuestionServiceInterface {

    List<QuestionDTO> findAll();

    Optional<QuestionDTO> findById(Long id);

    List<QuestionDTO> findAllByQuizCode(final String quizCode);

    Optional<QuestionDTO> save(final QuestionCommand questionCommand);

    void delete(Long id);

    Optional<QuestionDTO> update(final Long id, final QuestionCommand questionCommand);
}
