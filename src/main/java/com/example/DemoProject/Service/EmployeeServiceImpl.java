package com.example.DemoProject.Service;

import com.example.DemoProject.Service.EmployeeServiceImpl;
import com.example.DemoProject.DAO.EmployeeDAO;
import com.example.DemoProject.entity.EmployeeDTO;
import com.example.DemoProject.pojo.Employee;
import exception.AgeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    public List<EmployeeDTO> getEmployees() {
        List<EmployeeDTO> employeeDTOList=employeeDAO.findAll();
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO getEmployees(long eid) {

        return (EmployeeDTO) employeeDAO.getOne(eid);
    }

    @Override
    public String addEmployees(Employee employee) throws ParseException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setEid(employee.getEid());
        employeeDTO.setAge(employee.getAge());
        Date date1 = new SimpleDateFormat("mm-dd-yyyy").parse(employee.getDate());
        employeeDTO.setDate(date1);
       // employeeDTO.setDate(employee.getDate());

        int age = employee.getAge();

        if(age<=10){
            employeeDTO.setStatus("Kid");
        } else if (age<=13 && age<=19) {
            employeeDTO.setStatus("Adult");
        } else if (age>=20 && age<=40) {
            employeeDTO.setStatus("Citizen");
        }
        else if (age>=60){
            employeeDTO.setStatus("Senior Citizen");
        } else if (age>=100) {
            throw new AgeNotFound("InvalidAge");
        }
        employeeDAO.save(employeeDTO);
        return "Saved Successfully";
    }

    @Override
    public Employee cmpEmployees() {
        List<EmployeeDTO> employeeDTOList = employeeDAO.findAll();
        Collections.sort(employeeDTOList, new Comparator<EmployeeDTO>() {
            @Override
            public int compare(EmployeeDTO o1, EmployeeDTO o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        EmployeeDTO employeeDTO=employeeDTOList.get(0);
        Employee employee=new Employee();
        employee.setAge(employeeDTO.getAge());
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setEid(employeeDTO.getEid());
        return employee;
    }
    @Override
    public EmployeeDTO updEmployee(Employee employee) {
        EmployeeDTO employeeDTO = employeeDAO.findByEid(employee.getEid());
        employeeDTO.setSalary(34000.0);
        employeeDTO.setName("HiHello");
        return employeeDTO;
    }
}
