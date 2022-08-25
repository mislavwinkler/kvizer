package hr.tvz.winkler.kvizer.security.command;

import javax.validation.constraints.NotBlank;

public class RegisterCommand {

    @NotBlank(message = "Username must not be empty")
    private String username;

    @NotBlank(message = "Password must not be empty")
    private String password;

    @NotBlank(message = "Email is mandatory")
    private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {return email;}
}
