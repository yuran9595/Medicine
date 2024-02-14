package org.core.converter;

import org.core.dtos.DepartmentDto;
import org.core.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDtoToDepartmentConverter extends Converter<DepartmentDto, Department>{
    @Override
    public Department convert(DepartmentDto departmentDto) {
        return super.modelMapper.map(departmentDto, Department.class);
    }
}
