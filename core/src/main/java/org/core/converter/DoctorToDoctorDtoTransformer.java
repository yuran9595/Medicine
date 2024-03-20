package org.core.converter;

import org.core.dtos.DoctorDto;
import org.core.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorToDoctorDtoTransformer extends  Converter<Doctor, DoctorDto>{

    @Override
    public DoctorDto convert(Doctor doctor) {
        DoctorDto doctorDto = super.modelMapper.map(doctor, DoctorDto.class);
        doctorDto.setPassword("");
        return doctorDto;
    }
}
