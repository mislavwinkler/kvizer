package hr.tvz.winkler.kvizer.answer;

import hr.tvz.winkler.kvizer.question.Question;

import java.util.List;
import java.util.Optional;

public interface AnswerRepositoryInterface {

    List<Answer> findAll();

    Optional<Answer> findById(Long id);

    List<Answer> findAnswersByQuestionId(Long questionId);

    List<Answer> findAnswersByUserUsername(String userName);

    Optional<Answer> save(Answer answer);

    void delete(Long id);

    Optional<Answer> update(Long questionId, Answer updatedAnswer);
}
