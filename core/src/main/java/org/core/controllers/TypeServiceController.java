package org.core.controllers;

import lombok.RequiredArgsConstructor;
import org.core.dtos.TypeServiceDto;
import org.core.model.TypeService;
import org.core.services.TypeServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/public")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3006"})
public class TypeServiceController {
    private final TypeServiceService typeServiceService;
    @GetMapping("/typeServices")
    public ResponseEntity<List<TypeServiceDto>> getAllTypeServices(){
        return ResponseEntity.ok(typeServiceService.getAllTypeServices());
    }
}
