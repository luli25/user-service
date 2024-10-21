package com.proyectos.userservice.controller;

import com.proyectos.userservice.DTOs.ErrorResponse;
import com.proyectos.userservice.DTOs.SignUpDTO;
import com.proyectos.userservice.entity.User;
import com.proyectos.userservice.exception.EmailAlreadyExistsException;
import com.proyectos.userservice.exception.InvalidDataException;
import com.proyectos.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private ErrorResponse error;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> userSignUp(@RequestBody SignUpDTO signUpDTO) {
        try {
            User user = userService.signUp(signUpDTO);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (EmailAlreadyExistsException | InvalidDataException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }
}
