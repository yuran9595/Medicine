package org.core.converter;

import org.core.model.Doctor;
import org.core.model.Image;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class MultipartFileToImageConverter extends Converter<MultipartFile, Image>{
    @Override
    public Image convert(MultipartFile file) {
        return super.modelMapper.map(file, Image.class);
    }
}
