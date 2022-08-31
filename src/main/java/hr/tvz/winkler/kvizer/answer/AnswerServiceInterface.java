package hr.tvz.winkler.kvizer.answer;

import hr.tvz.winkler.kvizer.question.QuestionCommand;
import hr.tvz.winkler.kvizer.question.QuestionDTO;

import java.util.List;
import java.util.Optional;

public interface AnswerServiceInterface {

    List<AnswerDTO> findAll();

    Optional<AnswerDTO> findById(Long id);

    List<AnswerDTO> findAllByQuestionId(final Long questionId);

    List<AnswerDTO> findAllByUserUsername(String userName);

    Optional<AnswerDTO> save(final AnswerCommand answerCommand);

    void delete(Long id);

    Optional<AnswerDTO> update(final Long id, final AnswerCommand answerCommand);
}
