package com.example.webproject.service;
import com.example.webproject.dto.UserDto;
import com.example.webproject.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}