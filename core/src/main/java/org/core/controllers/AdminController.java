package org.core.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.core.dtos.DepartmentDto;
import org.core.dtos.DoctorDto;
import org.core.dtos.TypeServiceDto;
import org.core.model.Doctor;
import org.core.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Slf4j
@CrossOrigin("http://localhost:3006")
public class AdminController {
    private final AdminService adminService;
    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto,
                                                       MultipartFile file)throws FileUploadException {
//        return adminService.addDepartment(departmentDto);
        System.out.println();
        return null;
    }
    @PostMapping("/addTypeService")
    public ResponseEntity<TypeServiceDto> addTypeService(@RequestBody TypeServiceDto typeServiceDto){
        System.out.println();
        return adminService.addTypeService(typeServiceDto);
    }
    @PostMapping("/addDoctor")
    public void addTypeService(@RequestBody DoctorDto doctor){
         adminService.addDoctor(doctor);
    }
}

