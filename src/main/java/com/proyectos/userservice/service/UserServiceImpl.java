package com.proyectos.userservice.service;

import com.proyectos.userservice.DTOs.SignUpDTO;
import com.proyectos.userservice.constant.Constants;
import com.proyectos.userservice.entity.Phone;
import com.proyectos.userservice.entity.User;
import com.proyectos.userservice.exception.EmailAlreadyExistsException;
import com.proyectos.userservice.exception.InvalidDataException;
import com.proyectos.userservice.repository.PhoneRepository;
import com.proyectos.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PhoneRepository phoneRepository;

    public UserServiceImpl(UserRepository userRepository, PhoneRepository phoneRepository) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void signUp(SignUpDTO signUpRequest) {
        if(validateSignUpData(signUpRequest)) {
            User user = userRepository.findByEmail(signUpRequest.getEmail());
            Phone phones = signUpRequest.getPhones().stream().findAny().get();
            if (Objects.isNull(user)) {
                    userRepository.save(extractUserFromSignUpDTO(signUpRequest));
                    phoneRepository.save(phones);
            } else {
                throw new EmailAlreadyExistsException("This email is already in use");
            }
        } else {
            throw new InvalidDataException("Invalid data");
        }
    }

    private boolean validateSignUpData(SignUpDTO signUpDTO) {
        if(!signUpDTO.getEmail().isEmpty() && !signUpDTO.getPassword().isEmpty()) {
            if(signUpDTO.getEmail().matches(Constants.EMAIL_VALIDATION_REGEX) && signUpDTO.getPassword()
                    .matches(Constants.PASSWORD_VALIDATION_REGEX)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private User extractUserFromSignUpDTO(SignUpDTO request) {
        User user = User.builder()
                .user_id(UUID.randomUUID())
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .token("token")
                .phones(request.getPhones())
                .isActive(true)
                .created(new Date())
                .lastLogin(new Date())
                .build();

        return user;
    }
}
