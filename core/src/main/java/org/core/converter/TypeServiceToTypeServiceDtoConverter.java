package org.core.converter;

import org.core.dtos.TypeServiceDto;
import org.core.model.TypeService;
import org.springframework.stereotype.Component;

@Component
public class TypeServiceToTypeServiceDtoConverter extends Converter<TypeService, TypeServiceDto>{
    @Override
    public TypeServiceDto convert(TypeService typeService) {
        return super.modelMapper.map(typeService, TypeServiceDto.class);
    }
}
