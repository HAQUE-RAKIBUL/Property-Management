package com.practice.propertymanagement.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Property_table")
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Property_Title" , nullable = false)
    private String title;
    private String description;
    private String ownerName;
    @Column(name = "Owner_Mail" , nullable = false)
    private String ownerMail;
    private String ownerAddress;
    private int price;
}
