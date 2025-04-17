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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Employee> getEmployeebyid(int id) {
        try {
            Employee employee = er.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
            return ResponseEntity.ok(employee);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public Employee updateEmployeebyid(Employee employee, int id) {
        Employee employee1 = er.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
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

    public List<Employee> fetchEmployeesByAddress(String state) {
        return er.findAll().stream()
                .filter(employee -> employee.getAddress().getState().equals(state)).collect(Collectors.toList());
    }


    public List<Employee> getEmployeesByDepartmentName(String departmentName) {
        return er.findByDepartmentName(departmentName);
    }

    public List<Employee> findProductsWithSorting(String field) {
        return er.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public List<Department> getDepartment() {
        return dr.findAll();
    }

    public Page<Employee> findProductsWithPagination(int offset, int pageSize) {
        Page<Employee> employees = er.findAll(PageRequest.of(offset, pageSize));
        return employees;
    }

    public ResponseEntity<Employee> assignProjectToEmployee(int employeeId, int projectId) {
        try {
            Employee employee = er.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not Found"));
            Project project = pr.findById(projectId).orElseThrow(() -> new RuntimeException("Project not Found"));
            employee.getProjectsEntity().add(project);
            er.save(employee);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public List<Project> getProjects(Project project) {
        return pr.findAll();
    }

    public ResponseEntity<Employee> assignAddressToEmployee(int employeeId, int addressId) {
        try {
            Employee employee = er.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not Found"));
            Address address = ar.findById(addressId).orElseThrow(() -> new RuntimeException("Project not Found"));
            employee.setAddress(address);
            er.save(employee);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public List<Address> getAddress(Address address) {
        return ar.findAll();
    }

    public List<Employee> getEmployeesByDepartmentID(int departmentID) {
        return er.getEmployeesByDepartmentID(departmentID);
    }

    public void deleteDepartment(int departmentID) {
       er.deleteById(departmentID);
    }

    public void deleteProject(int projectID) {
        er.deleteById(projectID);
    }

    public ResponseEntity<String> assignDepartmentToEmployee(int employeeId, int departmentId) {

        try {
            Employee employee = er.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not Found"));
            Department department = dr.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not Found"));

 employee.setDepartmentEntity(department);

            er.save(employee);
            return ResponseEntity.ok("Employee " + employeeId+" is assigned with " + departmentId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



        public List<Employee> getEmployeesWithDetails() {
            return er.findAllWithDetails();
        }

}


