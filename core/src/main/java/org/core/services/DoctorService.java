package org.core.services;

import lombok.RequiredArgsConstructor;
import org.core.converter.DoctorToDoctorDtoTransformer;
import org.core.dtos.DoctorDto;
import org.core.model.Doctor;
import org.core.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorToDoctorDtoTransformer doctorToDoctorDtoTransformer;

    public List<DoctorDto> getAllDoctors(){
        return doctorRepository.findAll().stream()
                .filter(doctor -> doctor.getActive())
                .map(doctorToDoctorDtoTransformer::convert)
                .toList();
    }
}
