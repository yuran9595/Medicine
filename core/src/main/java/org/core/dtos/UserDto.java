package org.core.dtos;

import lombok.*;

@Data
public class UserDto {
    private Long id;
    private String login;
    private String password;
}
