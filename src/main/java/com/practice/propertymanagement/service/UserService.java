package com.practice.propertymanagement.service;

import com.practice.propertymanagement.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);
}
