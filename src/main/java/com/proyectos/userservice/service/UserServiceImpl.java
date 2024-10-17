package com.proyectos.userservice.service;

import com.proyectos.userservice.DTOs.SignUpDTO;
import com.proyectos.userservice.entity.User;
import com.proyectos.userservice.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signUp(SignUpDTO signUpRequest) {
        return null;
    }
}
