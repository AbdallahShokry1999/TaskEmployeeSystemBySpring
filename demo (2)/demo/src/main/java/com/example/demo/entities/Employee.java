package com.example.demo.entities;


import jakarta.persistence.*;

@Entity

@Table(name = "employee")
public class Employee {
    @Id
    private Long id;
    private String name;
    private double salary;
    private String role;
    private String password;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects projects;

    public Employee(Long id,double salary, String name, String role,String password, Department department, Projects projects) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.role = role;
        this.password = password;
        this.department = department;
        this.projects = projects;
    }

    public Employee() {
    }

    // Getters and setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Projects getProjects() {
        return projects;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }
}
