package com.practice.propertymanagement.service.impl;

import com.practice.propertymanagement.Converter.UserConverter;
import com.practice.propertymanagement.Entity.UserEntity;
import com.practice.propertymanagement.dto.UserDTO;
import com.practice.propertymanagement.repository.UserRepository;
import com.practice.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
