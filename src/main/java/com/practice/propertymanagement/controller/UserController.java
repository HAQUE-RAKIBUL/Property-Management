package com.practice.propertymanagement.controller;

import com.practice.propertymanagement.dto.PropertyModel;
import com.practice.propertymanagement.dto.UserDTO;
import com.practice.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1/properties")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO)
    {
        userDTO = userService.register(userDTO);
        // System.out.println(propertyModel);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);

    }
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO)
    {
        userDTO = userService.login(userDTO.getOwnerMail(), userDTO.getPassword());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }

}
