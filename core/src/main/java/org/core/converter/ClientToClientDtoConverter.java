package org.core.converter;

import org.core.dtos.ClientDto;
import org.core.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientDtoConverter extends Converter<Client, ClientDto> {
    @Override
    public ClientDto convert(Client client) {
        return super.modelMapper.map(client, ClientDto.class);
    }
}
