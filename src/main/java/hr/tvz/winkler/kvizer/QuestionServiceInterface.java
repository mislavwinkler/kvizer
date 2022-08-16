package hr.tvz.winkler.kvizer;

import java.util.List;
import java.util.Optional;

public interface QuestionServiceInterface {

    List<QuestionDTO> findAll();

    List<QuestionDTO> findAllByQuizCode(final String quizCode);

    Optional<QuestionDTO> save(final QuestionCommand questionCommand);

    void delete(String quizCode, Integer position);

    Optional<QuestionDTO> update(final String code, final QuestionCommand questionCommand);

}
