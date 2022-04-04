package com.practice.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyModel {
    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerMail;
    private String ownerAddress;
    private int price;

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getOwnerName() {
//        return ownerName;
//    }
//
//    public void setOwnerName(String ownerName) {
//        this.ownerName = ownerName;
//    }
//
//    public String getOwnerMail() {
//        return ownerMail;
//    }
//
//    public void setOwnerMail(String ownerMail) {
//        this.ownerMail = ownerMail;
//    }
//
//    public String getOwnerAddress() {
//        return ownerAddress;
//    }
//
//    public void setOwnerAddress(String ownerAddress) {
//        this.ownerAddress = ownerAddress;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
}
