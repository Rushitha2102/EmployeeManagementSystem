package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Model.Address;
import com.example.EmployeeManagementSystem.Model.Department;
import com.example.EmployeeManagementSystem.Model.Employee;
import com.example.EmployeeManagementSystem.Model.Project;
import com.example.EmployeeManagementSystem.Repo.EmployeeRepo;
import com.example.EmployeeManagementSystem.Service.EmployeeManagementServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeManagementController {
    @Autowired
    EmployeeManagementServer es;
    @PostMapping("/Employee")
public void addEmployees(@RequestBody Employee employee) {
        es.addEmployees(employee);
}
@PostMapping("/Department")
    public void addDepartments(@RequestBody Department department) {
        es.addDepartments(department);
}
@GetMapping("/Employee")
    public List<Employee> getEmployees() {
        return es.getEmployees();
}
@GetMapping("/Employee/{id}")
    public Employee getEmployeebyId(@PathVariable int id) {
        return es.getEmployeebyid(id);
}
@PutMapping("/Employee/{id}")
    public Employee updateEmployeebyid(@RequestBody Employee employee,@PathVariable int id) {
        return es.updateEmployeebyid(employee,id);
}
@DeleteMapping("/Employee/{id}")
    public void deleteEmployee(@PathVariable int id) {
        es.deleteEmployeebyid(id);
    }
    @PostMapping("/departments")
    public void addDepartment(@RequestBody Department department) {
        es.addDepartment(department);
    }

    @PostMapping("/projects")
    public void addProject(@RequestBody Project project) {
        es.addProject(project);
    }
    @PostMapping("/address")
    public void addAddress(@RequestBody Address address) {
        es.addAddress(address);
    }
    @GetMapping("/department/{id}")
    public List<Employee> fetchEmployeebydepartmentid(@PathVariable int id) {
      return  es.fetchEmployeebydeid(id);
    }

    @GetMapping("/address/{state}")
    public List<Employee> fetchEmployeesByState(@PathVariable String state) {
        return es.fetchEmployeesByAddress(state);
    }

    @GetMapping("/employees/department/name/{departmentName}")
    public List<Employee> getEmployeesByDepartmentName(@PathVariable String departmentName) {
return es.getEmployeesByDepartmentName(departmentName);
    }

}

