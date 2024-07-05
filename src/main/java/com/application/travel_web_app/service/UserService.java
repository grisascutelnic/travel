package com.application.travel_web_app.service;

import com.application.travel_web_app.dto.UserDto;
import com.application.travel_web_app.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
