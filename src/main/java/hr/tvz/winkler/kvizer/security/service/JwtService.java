package hr.tvz.winkler.kvizer.security.service;

import hr.tvz.winkler.kvizer.security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
