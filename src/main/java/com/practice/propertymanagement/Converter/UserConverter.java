package com.practice.propertymanagement.Converter;

import com.practice.propertymanagement.Entity.UserEntity;
import com.practice.propertymanagement.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDTOtoEntity(UserDTO userDTO)
    {
        UserEntity objUserEntity = new UserEntity();

        objUserEntity.setOwnerMail(userDTO.getOwnerMail());
        objUserEntity.setOwnerName(userDTO.getOwnerName());
        objUserEntity.setPassword(userDTO.getPassword());
        return objUserEntity;
    }

    public UserDTO convertEntitytoDTO(UserEntity userEntity)
    {
        UserDTO objUserDTO = new UserDTO();
        objUserDTO.setId(userEntity.getId());
        objUserDTO.setOwnerMail(userEntity.getOwnerMail());
        objUserDTO.setOwnerName(userEntity.getOwnerName());
        //objUserDTO.setPassword(userEntity.getPassword());
        return objUserDTO;
    }
}
