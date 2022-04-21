package com.practice.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyModel {
    private Long id;
    private String title;
    private String description;
    private String ownerAddress;
    private int price;


}
