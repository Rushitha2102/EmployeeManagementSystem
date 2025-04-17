package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Model.Address;
import com.example.EmployeeManagementSystem.Model.Department;
import com.example.EmployeeManagementSystem.Model.Employee;
import com.example.EmployeeManagementSystem.Model.Project;
import com.example.EmployeeManagementSystem.Repo.EmployeeRepo;
import com.example.EmployeeManagementSystem.Service.EmployeeManagementServer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeManagementController {
    @Autowired
    EmployeeManagementServer es;
    @PostMapping("/Employee")
public void addEmployees(@Valid @RequestBody Employee employee) {
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
    public ResponseEntity<Employee> getEmployeebyId(@PathVariable int id) {
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
@GetMapping("/viewemployeesbysorting/{field}")
    public List<Employee> getProductsWithsort(@PathVariable String field) {
        return es.findProductsWithSorting(field);
}
    @GetMapping("/Departments")
    public List<Department> getDepartment() {
        return es.getDepartment();
    }

    @GetMapping("/viewemployeebypaging/{offset}/{pageSize}")
    public Page<Employee> viewbyPagination(@PathVariable int offset,@PathVariable int pageSize) {
        Page<Employee> employees=es.findProductsWithPagination(offset, pageSize);
        return employees;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> InvalidArugment(MethodArgumentNotValidException exception) {
        Map<String,String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

    @PutMapping("/Employee/{employeeId}/{projectId}")
    public ResponseEntity<Employee> assignProjectToEmployee(@PathVariable int employeeId, @PathVariable int projectId) {
        return es.assignProjectToEmployee(employeeId, projectId);
    }

    @GetMapping("/projects")
    public List<Project> getProjects(Project project){
        return es.getProjects(project);
    }

    @PutMapping("/Employee/{employeeId}/Address/{addressId}")
    public ResponseEntity<Employee> assignAddressToEmployee(@PathVariable int employeeId, @PathVariable int addressId) {
 return es.assignAddressToEmployee(employeeId, addressId);
    }

    @GetMapping("/address")
    public List<Address> getAddress(Address address) {
        return es.getAddress(address);
}
    @GetMapping("/employees/department/id/{departmentID}")
    public List<Employee> getEmployeesByDepartmentID(@PathVariable int departmentID) {
        return es.getEmployeesByDepartmentID(departmentID);
    }
    @DeleteMapping("/department/{departmentID}")
    public void deleteDepartment(@PathVariable int departmentID) {
         es.deleteDepartment(departmentID);
    }
    @DeleteMapping("/Project/{ProjectID}")
    public void deleteProject(@PathVariable int ProjectID) {
        es.deleteProject(ProjectID);
    }

    @PutMapping("/Employee/{employeeId}/Department/{departmentId}")
    public ResponseEntity<String> assignDepartmentToEmployee(@PathVariable int employeeId, @PathVariable int departmentId) {
return es.assignDepartmentToEmployee(employeeId, departmentId);
    }
        @GetMapping("/EmployeeWithAll")
        public ResponseEntity<List<Employee>> getEmployeesWithDetails() {
            List<Employee> employees = es.getEmployeesWithDetails();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }


}


