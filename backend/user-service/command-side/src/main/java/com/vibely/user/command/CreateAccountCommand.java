package com.vibely.user.command;

import com.vibely.common.command.Command;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CreateAccountCommand implements Command {

    @NotBlank
    @Size(min = 1, max = 16)
    private String username;

    @NotBlank
    @Size(min = 1, max = 50)
    private String name;

    @Email
    @NotBlank
    @Size(min = 1, max = 320)
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private LocalDate dateOfBirth;

}
