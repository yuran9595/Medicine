package org.core.controllers;

import lombok.AllArgsConstructor;
import org.core.dtos.DepartmentDto;
import org.core.model.Department;
import org.core.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:19006", "http://localhost:3006"})
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
    @GetMapping("/department/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentId(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }
}
