package com.example.DemoProject.controller;

import com.example.DemoProject.Service.EmployeeService;
import com.example.DemoProject.entity.EmployeeDTO;
import com.example.DemoProject.pojo.Address;
import com.example.DemoProject.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    private EmployeeService employeeService;
    private Address addressService;

    @GetMapping("/getEmp")
    public List<EmployeeDTO> getEmployees(){
        return this.employeeService.getEmployees();
    }
    @GetMapping("/emp/{empID}")
    public EmployeeDTO getEmployee(long eId)
    {
        return this.employeeService.getEmployees(eId);
    }
    @PostMapping("/createEmployee")
    public String addEmployee(@RequestBody Employee employee) throws ParseException{
        return this.employeeService.addEmployees(employee);
    }
    @RequestMapping(value = "/updemp")
    public EmployeeDTO updateEmployee(@RequestBody Employee employee){
        return this.employeeService.updEmployee(employee);
    }
    @GetMapping("/FindSeniorEmp")
    public Employee cmpEmployees(){
    return this.employeeService.cmpEmployees();
    }
}
