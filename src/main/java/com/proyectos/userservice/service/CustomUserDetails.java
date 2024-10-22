package com.proyectos.userservice.service;

import com.proyectos.userservice.entity.User;
import com.proyectos.userservice.repository.UserRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    @Getter
    private User userDetail;

    public CustomUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername(): " + username);
        userDetail = userRepository.findByEmail(username);

        if(!Objects.isNull(userDetail)) {
            return new org.springframework.security.core.userdetails.User(userDetail.getName(),
                    userDetail.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User doesn't exists");
        }
    }

}
