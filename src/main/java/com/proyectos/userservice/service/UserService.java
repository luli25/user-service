package com.proyectos.userservice.service;

import com.proyectos.userservice.DTOs.SignUpDTO;
import com.proyectos.userservice.entity.User;

public interface UserService {
    User signUp(SignUpDTO signUpRequest);
}
