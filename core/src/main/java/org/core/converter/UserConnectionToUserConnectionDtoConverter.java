package org.core.converter;

import org.core.dtos.UserConnectionDto;
import org.core.model.UserConnection;
import org.springframework.stereotype.Component;

@Component
public class UserConnectionToUserConnectionDtoConverter extends Converter<UserConnection, UserConnectionDto>{
    @Override
    public UserConnectionDto convert(UserConnection userConnection) {
        return super.modelMapper.map(userConnection, UserConnectionDto.class);
    }
}
