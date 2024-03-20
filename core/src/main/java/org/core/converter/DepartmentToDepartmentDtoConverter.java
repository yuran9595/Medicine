package org.core.converter;

import org.core.dtos.DepartmentDto;
import org.core.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentToDepartmentDtoConverter extends Converter<Department, DepartmentDto> {
    @Override
    public DepartmentDto convert(Department department) {
        DepartmentDto map = super.modelMapper.map(department, DepartmentDto.class);
        if (department.getImages().size()!=0){
            map.setImageId(department.getImages().get(0).getId());
        }
        return map;
    }
}
