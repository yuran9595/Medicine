package org.core.dtos;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.core.model.Department;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeServiceDto {
    private Long id;
    private String name;
    private String description;
    private Long departmentId;

}
