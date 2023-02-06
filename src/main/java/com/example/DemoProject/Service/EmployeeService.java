package com.example.DemoProject.Service;

import com.example.DemoProject.DAO.EmployeeDAO;
import com.example.DemoProject.entity.EmployeeDTO;
import com.example.DemoProject.pojo.Employee;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {
    public List<EmployeeDTO> getEmployees();

    public EmployeeDTO getEmployees(long eid);

    public String addEmployees(Employee employee) throws ParseException;

//    public EmployeeDTO updateEmployees(Employee employee, String id);

    public Employee cmpEmployees();

    EmployeeDTO updEmployee(Employee employee);
}