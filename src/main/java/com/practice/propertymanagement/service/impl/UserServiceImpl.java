package com.practice.propertymanagement.service.impl;

import com.practice.propertymanagement.Converter.UserConverter;
import com.practice.propertymanagement.Entity.UserEntity;
import com.practice.propertymanagement.dto.UserDTO;
import com.practice.propertymanagement.exception.BusinessException;
import com.practice.propertymanagement.exception.ErrorModel;
import com.practice.propertymanagement.repository.UserRepository;
import com.practice.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optUe = userRepository.findbyOwnerMail(userDTO.getOwnerMail());
        if(optUe.isPresent())
        {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Email_Already_Exist");
            errorModel.setMessage("The email with which trying to register is already exist");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findbyOwnerMailAndPassword(email, password);

        if(optionalUserEntity.isPresent())
        {
            userDTO = userConverter.convertEntitytoDTO(optionalUserEntity.get());
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
