package org.core.controllers;

import lombok.RequiredArgsConstructor;
import org.core.model.UserConnection;
import org.core.services.UserConnectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserConnectionService userConnectionService;


}
