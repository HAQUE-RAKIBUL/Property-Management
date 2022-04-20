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
    private String ownerAddress;
    private int price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userEntity;
}
