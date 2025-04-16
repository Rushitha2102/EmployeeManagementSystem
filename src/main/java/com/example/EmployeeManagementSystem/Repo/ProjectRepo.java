package com.example.EmployeeManagementSystem.Repo;

import com.example.EmployeeManagementSystem.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
