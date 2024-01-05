package org.core.services;

import lombok.RequiredArgsConstructor;
import org.core.model.User;
import org.core.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
