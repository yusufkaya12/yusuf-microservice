package com.threepounds.authservice.service;


import com.threepounds.authservice.data.entity.User;
import com.threepounds.authservice.data.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
     return userRepository.findAll();
    }

    public Optional<User> getById(UUID id) {
        return userRepository.findById(id);
    }
}
