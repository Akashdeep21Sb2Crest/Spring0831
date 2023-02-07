package com.example.DemoProject.pojo;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data

public class Address {
    private long eid;
    private int door_number;
    private String city;
    private String state;
    private String street;
    private Long pincode;
    private Employee employee;

}
