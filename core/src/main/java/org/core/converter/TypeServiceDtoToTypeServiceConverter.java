package org.core.converter;

import org.core.dtos.TypeServiceDto;
import org.core.model.TypeService;
import org.springframework.stereotype.Component;

@Component
public class TypeServiceDtoToTypeServiceConverter extends Converter<TypeServiceDto, TypeService> {

    @Override
    public TypeService convert(TypeServiceDto typeServiceDto) {
        return super.modelMapper.map(typeServiceDto, TypeService.class);
    }
}
