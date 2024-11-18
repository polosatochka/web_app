package com.example.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.webproject.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
