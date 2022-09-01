package hr.tvz.winkler.kvizer.security.user.answer;

import hr.tvz.winkler.kvizer.security.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface AnswerServiceInterface {

    List<AnswerDTO> findAll();

    List<UserDTO> findUsersByQuizCode(String code);

    Optional<AnswerDTO> findById(Long id);

    List<AnswerDTO> findAllByQuestionId(final Long questionId);

    List<AnswerDTO> findAllByQuizCodeAndUsername(String quizCode, String username);

    Optional<AnswerDTO> save(final AnswerCommand answerCommand);

    void delete(Long id);

    Optional<AnswerDTO> update(final Long id, final AnswerCommand answerCommand);
}
