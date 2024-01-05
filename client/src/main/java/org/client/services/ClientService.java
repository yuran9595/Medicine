package org.client.services;

import org.core.dtos.ClientDto;

public interface ClientService {
    ClientDto registration(ClientDto clientDto);
}
