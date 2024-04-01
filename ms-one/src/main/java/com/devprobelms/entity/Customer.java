package com.devprobelms.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String customerName;

}
