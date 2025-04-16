package com.example.EmployeeManagementSystem.Repo;

import com.example.EmployeeManagementSystem.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {
}
