package hr.tvz.winkler.kvizer.answer;

import hr.tvz.winkler.kvizer.question.*;
import hr.tvz.winkler.kvizer.security.domain.User;
import hr.tvz.winkler.kvizer.security.dto.UserDTO;
import hr.tvz.winkler.kvizer.security.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerService implements AnswerServiceInterface {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    public AnswerService(QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AnswerDTO> findAll() {
        return answerRepository.findAll().stream().map(this::mapAnswerToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findUsersByQuizCode(String code) {
        return answerRepository.findAllUsersThatAnsweredByQuizCode(code).stream().map(this::mapUserToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<AnswerDTO> findById(Long id) {
        return answerRepository.findById(id).map(this::mapAnswerToDTO);
    }

    @Override
    public List<AnswerDTO> findAllByQuestionId(Long questionId) {
        return answerRepository.findAnswersByQuestionId(questionId).stream().map(this::mapAnswerToDTO).collect(Collectors.toList());
    }
    @Override
    public List<AnswerDTO> findAllByQuizCodeAndUsername(String quizCode, String username) {
        return answerRepository.findAnswersByQuizCodeAndUsername(quizCode, username).stream().map(this::mapAnswerToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<AnswerDTO> save(AnswerCommand answerCommand) {
        return answerRepository.save(mapAnswerCommandToQuestion(answerCommand))
                .map(this::mapAnswerToDTO);
    }

    @Override
    public void delete(Long id) {
        answerRepository.delete(id);
    }

    @Override
    public Optional<AnswerDTO> update(Long id, AnswerCommand answerCommand) {
        return answerRepository.update(id, mapAnswerCommandToQuestion(answerCommand)).
                map(this::mapAnswerToDTO);
    }

    private AnswerDTO mapAnswerToDTO(Answer answer) {
        return new AnswerDTO(answer.getId(), answer.getAnswer(), answer.getQuestion().getId(), answer.getUser().getUsername());
    }

    private UserDTO mapUserToDTO(User user) {
        return new UserDTO(user.getUsername());
    }

    private Answer mapAnswerCommandToQuestion(AnswerCommand answerCommand) {
        return new Answer(answerCommand.getId(), answerCommand.getAnswer(), questionRepository.findById(answerCommand.getQuestionId()).get(),
                userRepository.findByUsername(answerCommand.getUserName()).get());
    }

}
