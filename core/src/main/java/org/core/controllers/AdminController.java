package org.core.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.dtos.DepartmentDto;
import org.core.dtos.TypeServiceDto;
import org.core.model.Doctor;
import org.core.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Slf4j
@CrossOrigin("http://localhost:3006")
public class AdminController {
    private final AdminService adminService;
    @GetMapping("/registration")
    public ResponseEntity<?> testAdminMessage() {
        return null;
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto){
        return adminService.addDepartment(departmentDto);
    }
    @PostMapping("/addTypeService")
    public ResponseEntity<TypeServiceDto> addTypeService(@RequestBody TypeServiceDto typeServiceDto){
        System.out.println();
        return adminService.addTypeService(typeServiceDto);
    }
    @PostMapping("/addDoctor")
    public ResponseEntity<Doctor> addTypeService(@RequestBody Doctor doctor){
        return adminService.addDoctor(doctor);
    }
}

