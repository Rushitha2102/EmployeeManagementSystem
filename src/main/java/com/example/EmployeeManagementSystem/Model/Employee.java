
package com.example.EmployeeManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
        import jakarta.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    @NotNull(message = "Employee ID cannot be null")
    private Integer employeeId;

    @Column
    private String name;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department departmentEntity;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_projects",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projectsEntity;

    // Constructors
    public Employee() {
    }

    public Employee(Integer employeeId, String name, Address address, Department departmentEntity, Set<Project> projectsEntity) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.departmentEntity = departmentEntity;
        this.projectsEntity = projectsEntity;
    }

    // Getters and Setters
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartmentEntity() {
        return departmentEntity;
    }
        public void setDepartmentEntity (Department departmentEntity){
            this.departmentEntity = departmentEntity;
        }

        public Set<Project> getProjectsEntity () {
            return projectsEntity;
        }

        public void setProjectsEntity (Set<Project> projectsEntity) {
            this.projectsEntity = projectsEntity;
        }
    }
