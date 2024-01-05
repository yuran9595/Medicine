package org.core.services;

import lombok.AllArgsConstructor;
import org.core.model.Department;
import org.core.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
