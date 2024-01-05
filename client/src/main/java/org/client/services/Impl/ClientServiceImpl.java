package org.client.services.Impl;

import lombok.RequiredArgsConstructor;
import org.client.services.ClientService;
import org.core.dtos.ClientDto;
import org.core.converter.ClientDtoToClientConverter;
import org.core.converter.ClientToClientDtoConverter;
import org.core.enums.UserRole;
import org.core.model.Client;
import org.core.repositories.ClientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientDtoToClientConverter clientDtoToClientConverter;
    private final ClientToClientDtoConverter clientToClientDtoConverter;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ClientDto registration(ClientDto clientDto) {
        Client client = clientDtoToClientConverter.convert(clientDto);
        client.setPassword(passwordEncoder.encode(clientDto.getPassword()));
        client.setActive(true);
        Set<UserRole> userRoleSet = new HashSet<>();
        userRoleSet.add(UserRole.ROLE_CLIENT);
        client.setUserRoles(userRoleSet);
        Client save = clientRepository.save(client);
        save.setPassword(null);
        return clientToClientDtoConverter.convert(save);
    }
}
