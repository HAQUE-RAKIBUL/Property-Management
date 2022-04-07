package com.practice.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String ownerName;
    private String ownerMail;
    private String password;
}
