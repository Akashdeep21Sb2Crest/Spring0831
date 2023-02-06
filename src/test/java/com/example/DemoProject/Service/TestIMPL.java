package com.example.DemoProject.Service;

import com.example.DemoProject.DAO.EmployeeDAO;
import com.example.DemoProject.entity.EmployeeDTO;
import com.example.DemoProject.pojo.Employee;
import exception.AgeNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class TestIMPL {
    @Mock
    private EmployeeDAO employeeDAO;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    List<EmployeeDTO> employeeDTOList;
    @BeforeEach
    void get() {
        employeeDTOList=new ArrayList<>();
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setName("Madagaskar");
        employeeDTOList.add(employeeDTO);
    }
    @Test
    void createEmployee1() throws ParseException{
        Employee employee=new Employee();
        employee.setEid(3);
        employee.setName("KK");
        employee.setSalary(1000);
        employee.setAge(80);
        employee.setDate("01-02-1908");
        assertEquals("Saved Successfully",employeeService.addEmployees(employee));
    }
    public void ExceptionHandle(){
        Employee employee=new Employee();
        employee.setEid(3);
        employee.setName("KK");
        employee.setSalary(1000);
        employee.setAge(100);
        employee.setDate("01-02-1908");
        Exception exception =assertThrows(AgeNotFound.class, ()->
        { employeeService.addEmployees(employee);

        });
       String e="InvalidAge";
       String a=exception.getMessage();
       assertTrue(a.contains(e));
    }

}
