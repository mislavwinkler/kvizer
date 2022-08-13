package hr.tvz.winkler.kvizer.security.service;

import hr.tvz.winkler.kvizer.security.command.LoginCommand;
import hr.tvz.winkler.kvizer.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
