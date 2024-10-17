package com.proyectos.userservice.repository;

import com.proyectos.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "select * from User u where u.email:= email", nativeQuery = true)
    User findByEmail(@Param("email") String email);
}
