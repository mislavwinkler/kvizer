package hr.tvz.winkler.kvizer.security.service;

import hr.tvz.winkler.kvizer.Quiz;
import hr.tvz.winkler.kvizer.QuizCommand;
import hr.tvz.winkler.kvizer.security.command.LoginCommand;
import hr.tvz.winkler.kvizer.security.command.RegisterCommand;
import hr.tvz.winkler.kvizer.security.domain.Authority;
import hr.tvz.winkler.kvizer.security.domain.User;
import hr.tvz.winkler.kvizer.security.dto.LoginDTO;
import hr.tvz.winkler.kvizer.security.dto.UserDTO;
import hr.tvz.winkler.kvizer.security.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<LoginDTO> login(LoginCommand command) {
        Optional<User> user = userRepository.findByUsername(command.getUsername());

        if (user.isEmpty() || !isMatchingPassword(command.getPassword(), user.get().getPassword())) {
            return Optional.empty();
        }

        return Optional.of(
                new LoginDTO(jwtService.createJwt(user.get()))
        );
    }

    @Override
    public Optional<UserDTO> save(RegisterCommand command) {
        Optional<User> user = userRepository.save(mapRegisterCommandToUser(command));
        if (user.isEmpty() || !isMatchingPassword(command.getPassword(), user.get().getPassword())) {
            return Optional.empty();
        }

        return Optional.of(
                new UserDTO(user.get().getUsername())
        );
        }

    private User mapRegisterCommandToUser(RegisterCommand registerCommand) {
        return new User(registerCommand.getUsername(), BCrypt.hashpw(registerCommand.getPassword(), BCrypt.gensalt()), registerCommand.getEmail());
    }


    private boolean isMatchingPassword(String rawPassword, String encryptedPassword) {
        return BCrypt.checkpw(rawPassword, encryptedPassword);
    }
}
