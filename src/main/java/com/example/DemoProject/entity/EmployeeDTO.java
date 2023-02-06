package com.example.DemoProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "emp")
public class EmployeeDTO {

    @Id
    @Column(name = "em_id")
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

}
