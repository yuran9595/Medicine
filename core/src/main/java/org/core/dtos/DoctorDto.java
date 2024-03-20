package org.core.dtos;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto extends UserDto {
    private Long id;
    @Size(min = 3, max = 20, message = "First name should contain at least 3 characters")
    private String firstName;
    @Size(min = 3, max = 20, message = "Middle name should contain at least 3 characters")
    private String middleName;
    @Size(min = 3, max = 20, message = "Last name should contain at least 3 characters")
    private String lastName;
    private String specialityDescription;
    private Long typeServiceId;
}
