package org.core.controllers;

import lombok.RequiredArgsConstructor;
import org.core.dtos.DoctorDto;
import org.core.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:19006", "http://localhost:3006"})
@RequiredArgsConstructor

public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/getDoctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        List<DoctorDto> allDoctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(allDoctors, HttpStatus.OK);
    }
}
