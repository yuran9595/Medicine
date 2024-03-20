package org.core.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class UserDto {
    private Long id;
    @Size(min = 4, max = 30, message = "Login should contain at least 4 characters")
    private String login;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password should contain at least eight characters, including at least one number and includes both lower and uppercase letters and special characters, for example #, ?, !.")
    private String password;
}
