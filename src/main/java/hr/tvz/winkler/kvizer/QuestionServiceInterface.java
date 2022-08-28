package hr.tvz.winkler.kvizer;

import java.util.List;
import java.util.Optional;

public interface QuestionServiceInterface {

    List<QuestionDTO> findAll();

    List<QuestionDTO> findAllByQuizCode(final String quizCode);

    Optional<QuestionDTO> save(final QuestionCommand questionCommand);

    void delete(Long id);

    Optional<QuestionDTO> update(final Long id, final QuestionCommand questionCommand);
}
