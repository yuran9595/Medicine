package org.core.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.core.dtos.DepartmentDto;
import org.core.dtos.DoctorDto;
import org.core.dtos.TypeServiceDto;
import org.core.services.AdminService;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Slf4j
@CrossOrigin("http://localhost:3006")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDto> addDepartment(DepartmentDto departmentDto,
                                                       MultipartFile file) throws FileUploadException {
        return adminService.addDepartment(departmentDto, file);
    }

    @PostMapping("/addTypeService")
    public ResponseEntity<TypeServiceDto> addDoctor(@RequestBody TypeServiceDto typeServiceDto) {
        System.out.println();
        return adminService.addTypeService(typeServiceDto);
    }

    @PostMapping("/addDoctor")
    public ResponseEntity<?> addDoctor(@RequestBody @Valid DoctorDto doctor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<String> strings = fieldErrors.stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            return new ResponseEntity<>(strings.get(0), HttpStatus.BAD_REQUEST);
        }
        adminService.addDoctor(doctor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> newMethod(SQLException exception) {
        System.out.println(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

