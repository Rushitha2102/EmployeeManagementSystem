package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Model.Address;
import com.example.EmployeeManagementSystem.Model.Department;
import com.example.EmployeeManagementSystem.Model.Employee;
import com.example.EmployeeManagementSystem.Model.Project;
import com.example.EmployeeManagementSystem.Repo.AddressRepo;
import com.example.EmployeeManagementSystem.Repo.DepartmentRepo;
import com.example.EmployeeManagementSystem.Repo.EmployeeRepo;
import com.example.EmployeeManagementSystem.Repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManagementServer {
@Autowired
    EmployeeRepo er;
@Autowired
DepartmentRepo dr;
@Autowired
    ProjectRepo pr;
@Autowired
    AddressRepo ar;
    public void addEmployees(Employee employee) {
       er.save(employee);
    }
    public void addDepartments(Department department) {
        dr.save(department);
    }

    public List<Employee> getEmployees() {
       return er.findAll();
    }

    public Employee getEmployeebyid(int id) {
        return er.findById(id).orElse(new Employee());
    }

    public Employee updateEmployeebyid(Employee employee, int id) {
        Employee employee1 = er.findById(id).orElseThrow(()->new RuntimeException("id not found"));
        employee1.setAddress(employee.getAddress());
        return employee1;
    }

    public void deleteEmployeebyid(int id) {
        er.deleteById(id);
    }

    public void addDepartment(Department department) {
        dr.save(department);
    }

    public void addProject(Project project) {
        pr.save(project);
    }
    public void addAddress(Address address) {
        ar.save(address);
    }

    public List<Employee> fetchEmployeebydeid(int id) {
      return er.findAll().stream().filter(employee -> employee.getDepartmentEntity().getDepartmentId() == id).collect(Collectors.toList());

    }

    public List<Employee> fetchEmployeesByAddress(String state) {return er.findAll().stream()
.filter(employee -> employee.getAddress().getState().equals(state)).collect(Collectors.toList());
    }


    public List<Employee> getEmployeesByDepartmentName(String departmentName) {
 return er.findByDepartmentName(departmentName);
 }

}
