package org.core.services;

import lombok.RequiredArgsConstructor;
import org.core.converter.*;
import org.core.dtos.DepartmentDto;
import org.core.dtos.DoctorDto;
import org.core.dtos.TypeServiceDto;
import org.core.model.Department;
import org.core.model.Doctor;
import org.core.model.Image;
import org.core.model.TypeService;
import org.core.repositories.DepartmentRepository;
import org.core.repositories.DoctorRepository;
import org.core.repositories.TypeServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
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
    private final DoctorDtoToDoctorConverter doctorDtoToDoctorConverter;
    private final DoctorRepository doctorRepository;
    private final MultipartFileToImageConverter multipartFileToImageConverter;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<DepartmentDto> addDepartment(DepartmentDto departmentDto, MultipartFile file) {
        Image image = multipartFileToImageConverter.convert(file);
        Department department = departmentDtoToDepartmentConverter.convert(departmentDto);
        image.setDepartment(department);
        department.getImages().add(image);
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

    public void addDoctor(DoctorDto doctorDto) {
        Doctor doctor = doctorDtoToDoctorConverter.convert(doctorDto);
        TypeService typeService = typeServiceRepository.findById(doctorDto.getTypeServiceId()).orElse(null);
        doctor.setTypeService(typeService);
        typeService.getDoctors().add(doctor);
        doctor.setActive(true);
        doctor.setPassword(passwordEncoder.encode(doctorDto.getPassword()));
        doctorRepository.save(doctor);
    }
}
