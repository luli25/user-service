package com.proyectos.userservice.DTOs;

import com.proyectos.userservice.entity.Phone;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SignUpDTO {
    private String name;
    private String email;
    private String password;
    List<Phone> phones;
}
