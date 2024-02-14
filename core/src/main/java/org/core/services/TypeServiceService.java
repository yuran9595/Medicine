package org.core.services;

import lombok.RequiredArgsConstructor;
import org.core.converter.TypeServiceToTypeServiceDtoConverter;
import org.core.dtos.TypeServiceDto;
import org.core.model.TypeService;
import org.core.repositories.TypeServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeServiceService {
    private final TypeServiceRepository typeServiceRepository;
    private final TypeServiceToTypeServiceDtoConverter typeServiceToTypeServiceDtoConverter;
    public List<TypeServiceDto> getAllTypeServices() {
       return typeServiceRepository.findAll().stream()
               .map(typeServiceToTypeServiceDtoConverter::convert)
               .toList();
    }
}
