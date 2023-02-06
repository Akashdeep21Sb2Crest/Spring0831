package com.example.DemoProject.DAO;

import com.example.DemoProject.entity.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeDTO, Long> {

    EmployeeDTO findByEid(long id);

}
