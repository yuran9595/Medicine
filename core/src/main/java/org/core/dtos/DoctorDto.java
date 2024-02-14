package org.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto extends UserDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String specialityDescription;
    private Long typeServiceId;
}
