package org.core.converter;

import org.core.dtos.ClientDto;
import org.core.model.Client;
import org.springframework.stereotype.Component;
@Component
public class ClientDtoToClientConverter extends Converter<ClientDto, Client> {
    @Override
    public Client convert(ClientDto clientDto) {

        return super.modelMapper.map(clientDto, Client.class);
    }
}
