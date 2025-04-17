package com.example.EmployeeManagementSystem.Repo;

import com.example.EmployeeManagementSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    @Query("SELECT e FROM Employee e WHERE e.departmentEntity.name = :departmentName")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.departmentEntity.id = :departmentId")
    List<Employee> getEmployeesByDepartmentID(@Param("departmentId") int departmentId);
        @Query("SELECT e FROM Employee e JOIN FETCH e.department d JOIN FETCH e.project p JOIN FETCH e.address a")
        List<Employee> findAllWithDetails();

}

