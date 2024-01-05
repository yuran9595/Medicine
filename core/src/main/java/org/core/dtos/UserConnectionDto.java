package org.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserConnectionDto {
    private Long id;
    private String nameOfConnection;
    private String value;
    private UserDto user;
}
