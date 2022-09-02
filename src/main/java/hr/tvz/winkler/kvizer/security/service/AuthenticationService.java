package hr.tvz.winkler.kvizer.security.service;

import hr.tvz.winkler.kvizer.security.command.LoginCommand;
import hr.tvz.winkler.kvizer.security.command.RegisterCommand;
import hr.tvz.winkler.kvizer.security.dto.LoginDTO;
import hr.tvz.winkler.kvizer.security.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface AuthenticationService {

    List<UserDTO> findAll();

    Optional<LoginDTO> login(LoginCommand command);

    Optional<UserDTO> save(RegisterCommand command);

    void delete(String username);
}
