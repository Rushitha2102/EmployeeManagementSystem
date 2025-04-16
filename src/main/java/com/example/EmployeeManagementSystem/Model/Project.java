
package com.example.EmployeeManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
        import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    @Column
    private String name;

    @Column
    private String description;
@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "projectsEntity")
    private Set<Employee> employees;

    // Constructors
    public Project() {}

    public Project(int projectId, String name, String description, Set<Employee> employees) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.employees = employees;
    }

    // Getters and Setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
