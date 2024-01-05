package org.client.controllers;

import lombok.RequiredArgsConstructor;
import org.core.dtos.UserConnectionDto;
import org.core.services.UserConnectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserClientController {
    private final UserConnectionService userConnectionService;

    @GetMapping("/getConnections/{userId}")
    public ResponseEntity<?> getUserConnections(@PathVariable Long userId) {
        List<UserConnectionDto> connections = userConnectionService.getConnections(userId);
        return new ResponseEntity<>(connections, HttpStatus.OK);
    }
}

