package com.example.DemoProject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "emp")
public class EmployeeDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "em_id",nullable = false)
    private long eid;

    @Column(name = "emp_Name")
    private String name;
    @Column(name = "emp_salary")
    private double salary;
    @Column(name = "emp_Age")
    private int age;
    @Column(name = "emp_Date")
    private Date date;
    @Column(name = "emp_Status")
    private String Status;

    @OneToMany(mappedBy = "employeeDTO",cascade = CascadeType.ALL)
    private List<AddressDTO> addressDTO;

}
