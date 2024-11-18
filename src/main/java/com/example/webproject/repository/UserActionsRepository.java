package com.example.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.webproject.entity.UserActions;

@Repository
public interface UserActionsRepository extends JpaRepository<UserActions,Long> {

}
