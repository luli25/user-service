package com.proyectos.userservice.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID user_id;
    private String name;
    private String password;
    private String email;
    private String token;
    private boolean isActive;
    private Date created;
    private Date lastLogin;
    @OneToMany
    @JoinColumn(columnDefinition = "phone_id")
    private List<Phone> phones;
}
