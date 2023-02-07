package com.example.DemoProject.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private long eid;
    private String name;
    private double salary;
    private int age;
    private String date;
    private List<Address> address;
}
