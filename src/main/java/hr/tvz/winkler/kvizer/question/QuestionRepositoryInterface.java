package hr.tvz.winkler.kvizer.question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepositoryInterface{

    List<Question> findAll();

    Optional<Question> findById(Long id);

    List<Question> findQuestionsByQuizCode(String quizCode);

    Optional<Question> save(Question question);

    void delete(Long id);

    Optional<Question> update(Long questionId, Question updatedQuestion);
}
