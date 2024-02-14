package org.core.converter;

import org.core.dtos.DepartmentDto;
import org.core.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentToDepartmentDtoConverter extends Converter<Department, DepartmentDto> {
    @Override
    public DepartmentDto convert(Department department) {
        return super.modelMapper.map(department, DepartmentDto.class);
    }
}
