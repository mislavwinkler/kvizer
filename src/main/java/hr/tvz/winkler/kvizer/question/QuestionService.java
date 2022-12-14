package hr.tvz.winkler.kvizer.question;

import hr.tvz.winkler.kvizer.quiz.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService implements QuestionServiceInterface{

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public List<QuestionDTO> findAll() {
        return questionRepository.findAll().stream().map(this::mapQuestionToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<QuestionDTO> findById(Long id) {
        return questionRepository.findById(id).map(this::mapQuestionToDTO);
    }

    @Override
    public List<QuestionDTO> findAllByQuizCode(String quizCode) {
        return questionRepository.findQuestionsByQuizCode(quizCode).stream().map(this::mapQuestionToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<QuestionDTO> save(QuestionCommand questionCommand) {
        return questionRepository.save(mapQuestionCommandToQuestion(questionCommand))
                .map(this::mapQuestionToDTO);
    }

    @Override
    public void delete(Long id) {
        questionRepository.delete(id);
    }

    @Override
    public Optional<QuestionDTO> update(Long id, QuestionCommand questionCommand) {
        return questionRepository.update(id, mapQuestionCommandToQuestion(questionCommand)).
                map(this::mapQuestionToDTO);
    }

    private QuestionDTO mapQuestionToDTO(Question question) {
        return new QuestionDTO(question.getId(), question.getPosition(), question.getQuestion(), question.getAnswer(), question.getQuiz().getCode());
    }

    private Question mapQuestionCommandToQuestion(QuestionCommand questionCommand) {
        return new Question(questionCommand.getId(), questionCommand.getPosition(), questionCommand.getQuestion(),
                questionCommand.getAnswer(), quizRepository.findByCode(questionCommand.getQuizCode()).get());
    }
}
