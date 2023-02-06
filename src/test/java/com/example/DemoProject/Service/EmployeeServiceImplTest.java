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
import org.mockito.Mockito;
import org.mockito.stubbing.Stubber;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeDAO employeeDAO;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    List<EmployeeDTO> employeeDTOList;
    @BeforeEach
    void addEmployees() {
        employeeDTOList=new ArrayList<>();
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setName("kgjghgkjgghjdoiarhhfjkvjdraeigjajkoaa");
        employeeDTO.setAge(25);
        employeeDTOList.add(employeeDTO);
    }

    @Test
    void createEmployees() throws ParseException{
        //Mockito.doNothing(employeeDAO).save();
        //Mockito.doNothing(employeeDAO.save(Mockito.any()));
        Employee employee=new Employee();
        employee.setEid(1);
        employee.setSalary(1000);
        employee.setAge(10);
        employee.setDate("01-02-2023");
        assertEquals("Saved Successfully",employeeService.addEmployees(employee));
    }

    @Test
    void createEmployeeAudit() throws ParseException {
        //Mockito.doNothing(employeeDAO).save();
        //Mockito.doNothing(employeeDAO.save(Mockito.any()));
        Employee employee=new Employee();
        employee.setEid(1);
        employee.setSalary(1000);
        employee.setAge(20);
        employee.setDate("01-02-2023");
        assertEquals("Saved Successfully",employeeService.addEmployees(employee));
    }


    @Test
    void createEmployeeAudit1() throws ParseException {
        //Mockito.doNothing(employeeDAO).save();
        //Mockito.doNothing(employeeDAO.save(Mockito.any()));
        Employee employee=new Employee();
        employee.setEid(1);
        employee.setSalary(1000);
        employee.setAge(40);
        employee.setDate("01-02-2023");
        assertEquals("Saved Successfully",employeeService.addEmployees(employee));
    }

    @Test
    void createEmployeeAudit2(){
        //Mockito.doNothing(employeeDAO).save();
        //Mockito.doNothing(employeeDAO.save(Mockito.any()));
        Employee employee=new Employee();
        employee.setEid(1);
        employee.setSalary(1000);
        employee.setAge(500);
        employee.setDate("01-02-2023");

        Exception exception = assertThrows(AgeNotFound.class, ()->
                {
                  employeeService.addEmployees(employee);
                });

        String expectedMessage = "InvalidAge";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void getEmployees() {
        Mockito.when(employeeDAO.findAll()).thenReturn(employeeDTOList);
        List<EmployeeDTO> employeeDTO= employeeService.getEmployees();
        //assertEquals("kgjghgkjgghjdoiarhhfjkvjdraeigjajkoaa",employeeDTO.get(0).getName());
        assertNotNull(employeeDTO);
    }
    @Test
    void cmpEmployees(){
        Mockito.when(employeeDAO.findAll()).thenReturn(employeeDTOList);
    }
    }