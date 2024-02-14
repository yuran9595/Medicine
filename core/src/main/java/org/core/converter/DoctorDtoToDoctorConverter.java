package org.core.converter;

import org.core.dtos.DoctorDto;
import org.core.model.Department;
import org.core.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorDtoToDoctorConverter extends Converter<DoctorDto, Doctor>{
    @Override
    public Doctor convert(DoctorDto doctorDto) {
        return super.modelMapper.map(doctorDto, Doctor.class);
    }
}
