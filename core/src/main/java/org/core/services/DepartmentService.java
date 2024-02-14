package org.core.services;

import lombok.AllArgsConstructor;
import org.core.converter.DepartmentToDepartmentDtoConverter;
import org.core.dtos.DepartmentDto;
import org.core.model.Department;
import org.core.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentToDepartmentDtoConverter departmentToDepartmentDtoConverter;

    public List<DepartmentDto> getAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDto> departmentDtos = departments.stream()
                .map(department -> departmentToDepartmentDtoConverter.convert(department))
                .toList();
        return departmentDtos;
    }

    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return departmentToDepartmentDtoConverter.convert(department);
    }
}
