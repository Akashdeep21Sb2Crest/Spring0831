package com.example.DemoProject.DAO;

import com.example.DemoProject.entity.AddressDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<AddressDTO, Long> {

}
