package org.client.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.client.services.Impl.ClientServiceImpl;
import org.core.dtos.ClientDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
@Slf4j
public class RegistrationController {
private final ClientServiceImpl clientService;

    @PostMapping("/registration")
    public ResponseEntity<ClientDto> registration(@RequestBody ClientDto clientDto){
        ClientDto registration = clientService.registration(clientDto);
        log.info("New client has been registered with login - " + registration.getLogin());
        return new ResponseEntity<>(registration, HttpStatus.OK);
        // todo сделать секьюрный запрос любой получить список userConnections
    }
}
