package hr.tvz.winkler.kvizer.security.user.answer;

import hr.tvz.winkler.kvizer.security.domain.User;

import java.util.List;
import java.util.Optional;

public interface AnswerRepositoryInterface {

    List<Answer> findAll();

    List<User> findAllUsersThatAnsweredByQuizCode(String code);

    Optional<Answer> findById(Long id);

    List<Answer> findAnswersByQuestionId(Long questionId);

    List<Answer> findAnswersByQuizCodeAndUsername(String quizCode, String userName);

    Optional<Answer> save(Answer answer);

    void delete(Long id);

    Optional<Answer> update(Long questionId, Answer updatedAnswer);
}
