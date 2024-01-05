package org.core.converter;

import org.modelmapper.ModelMapper;

public abstract class Converter<T,E> {

    final ModelMapper modelMapper;
    protected Converter() {
        this.modelMapper = new ModelMapper();
    }

    public abstract E convert(T t);
}
