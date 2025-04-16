package com.example.EmployeeManagementSystem.Repo;

import com.example.EmployeeManagementSystem.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
