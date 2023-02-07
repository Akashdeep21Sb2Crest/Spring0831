package com.example.DemoProject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "address")
public class AddressDTO {
    @Id
    @Column(name = "door_number")
    private int door_number;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;
    @Column(name = "street")
    private String street;
    @Column(name = "pincode")
    private Long pincode;

    @ManyToOne
    @JoinColumn(name = "eid", nullable = false)
    private EmployeeDTO employeeDTO;
}
