package hr.tvz.winkler.kvizer;

import java.util.List;
import java.util.Optional;

public interface QuestionRepositoryInterface{

    List<Question> findAll();

    List<Question> findQuestionsByQuizCode(String quizCode);

    Optional<Question> save(Question question);

    void deleteQuestionByQuizCodeAndQuestionPosition(String quizCode, Integer position);

    Optional<Question> update(String quizCode, Integer oldPosition, Question updatedQuestion);
}
