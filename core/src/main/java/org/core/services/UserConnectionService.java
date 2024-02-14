package org.core.services;

import lombok.RequiredArgsConstructor;
import org.core.dtos.UserConnectionDto;
import org.core.converter.UserConnectionToUserConnectionDtoConverter;
import org.core.model.UserConnection;
import org.core.repositories.UserConnectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserConnectionService {
    private final UserConnectionRepository userConnectionRepository;
    private final UserConnectionToUserConnectionDtoConverter userConnectionToUserConnectionDtoConverter;

    @Transactional
    public List<UserConnectionDto> getConnections(Long userId) {
        List<UserConnection> connections = userConnectionRepository.findAllByUserId(userId);
        List<UserConnectionDto> collect = connections.stream()
                .map(c -> userConnectionToUserConnectionDtoConverter.convert(c))
                .map(userConnectionDto -> {
                    userConnectionDto.getUser().setPassword(" ");
                    return userConnectionDto;
                })
                .collect(Collectors.toList());

        return collect;
    }
}
