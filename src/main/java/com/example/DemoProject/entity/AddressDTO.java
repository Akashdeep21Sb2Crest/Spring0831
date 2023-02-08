package com.example.DemoProject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "address")
public class AddressDTO {

    @Column(name = "address_id")
    private Long addressID;

    @Id
    @Column(name = "door_num")
    private int doorNum;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;
    @Column(name = "street")
    private String street;
    @Column(name = "pincode")
    private Long pincode;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "em_id", nullable = false)
    private EmployeeDTO employeeDTO;
}
