package org.core.services;

import lombok.RequiredArgsConstructor;
import org.core.converter.DepartmentDtoToDepartmentConverter;
import org.core.converter.DepartmentToDepartmentDtoConverter;
import org.core.converter.TypeServiceDtoToTypeServiceConverter;
import org.core.converter.TypeServiceToTypeServiceDtoConverter;
import org.core.dtos.DepartmentDto;
import org.core.dtos.TypeServiceDto;
import org.core.model.Department;
import org.core.model.Doctor;
import org.core.model.TypeService;
import org.core.repositories.DepartmentRepository;
import org.core.repositories.TypeServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentDtoToDepartmentConverter departmentDtoToDepartmentConverter;
    private final DepartmentToDepartmentDtoConverter departmentToDepartmentDtoConverter;
    private final TypeServiceDtoToTypeServiceConverter typeServiceDtoToTypeService;
    private final TypeServiceToTypeServiceDtoConverter typeServiceToTypeServiceDtoConverter;
    private final TypeServiceRepository typeServiceRepository;

    public ResponseEntity<DepartmentDto> addDepartment(DepartmentDto departmentDto) {
        Department department = departmentDtoToDepartmentConverter.convert(departmentDto);
        Department save = departmentRepository.save(department);
        DepartmentDto convert = departmentToDepartmentDtoConverter.convert(save);
        return ResponseEntity.ok(convert);
    }
    public ResponseEntity<TypeServiceDto> addTypeService(TypeServiceDto typeServiceDto) {
        TypeService typeService = typeServiceDtoToTypeService.convert(typeServiceDto);
        Department department = departmentRepository.findById(typeServiceDto.getDepartmentId()).orElse(null);
        typeService.setDepartment(department);
        TypeService save = typeServiceRepository.save(typeService);
        TypeServiceDto convert = typeServiceToTypeServiceDtoConverter.convert(save);
        return ResponseEntity.ok(convert);

    }

    public ResponseEntity<Doctor> addDoctor(Doctor doctor) {
        System.out.println();
        return null;
    }
}
