package hr.tvz.winkler.kvizer;

import hr.tvz.winkler.kvizer.security.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService implements QuizServiceInterface{

    private final UserRepository userRepository;
    private final QuizRepository quizRepository;

    public QuizService(UserRepository userRepository, QuizRepository quizRepository) {
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
    }


    @Override
    public List<QuizDTO> findAll() {
        return quizRepository.findAll().stream().map(this::mapQuizToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<QuizDTO> findByCode(String code) {
        return quizRepository.findByCode(code).map(this::mapQuizToDTO);
    }

    @Override
    public Optional<QuizDTO> save(QuizCommand quizCommand) {
        return quizRepository.save(mapQuizCommandToQuiz(quizCommand)).map(this::mapQuizToDTO);
    }

    @Override
    public void delete(String code) {
            quizRepository.delete(code);
    }

    @Override
    public Optional<QuizDTO> update(String code, QuizCommand quizCommand) {
        return quizRepository.update(code, mapQuizCommandToQuiz(quizCommand)).
                map(this::mapQuizToDTO);
    }

    private QuizDTO mapQuizToDTO(final Quiz quiz) {
        return new QuizDTO(quiz.getCode(), quiz.getName(), quiz.getCreationDate(), quiz.getMaker().getUsername());
    }

    private Quiz mapQuizCommandToQuiz(QuizCommand quizCommand) {
        return new Quiz(quizCommand.getCode(),quizCommand.getName(),
                userRepository.findByUsername(quizCommand.getMakerName()).orElse(null));
    }
}
