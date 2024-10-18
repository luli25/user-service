package com.proyectos.userservice.service;

import com.proyectos.userservice.DTOs.SignUpDTO;

public interface UserService {
    void signUp(SignUpDTO signUpRequest);
}
