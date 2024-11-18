package com.example.webproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.webproject.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
