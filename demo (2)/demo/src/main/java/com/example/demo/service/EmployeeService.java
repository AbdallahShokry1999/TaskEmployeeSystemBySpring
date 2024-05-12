package com.example.demo.service;

import com.example.demo.entities.Members;
import com.example.demo.entities.Roles;
import com.example.demo.repo.MembersRepository;
import com.example.demo.repo.RolesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Employee;
import com.example.demo.repo.EmployeeRepository;
import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public List<Object[]> getIdAndName(){

        return employeeRepository.findAllEmployeeTwoC();
    }
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id).orElse(null);
    }

    public Object[] findEmployeeTwoCById(Long employeeId) {
        return employeeRepository.findEmployeeTwoCById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        // Synchronize data with Members entity
        Members members = new Members(employee.getName(), employee.getPassword(), (short)1 );
        membersRepository.save(members);

        // Synchronize data with Roles entity
        Roles roles = new Roles(employee.getName(), employee.getRole());
        rolesRepository.save(roles);

        // Save or update employee data
        employeeRepository.save(employee);
    }


    @Transactional
    public void updateEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            // Delete corresponding data from Members and Roles entities
            rolesRepository.deleteByUserId(employee.getName());
            membersRepository.deleteByUserId(employee.getName());

            // Delete employee data
            employeeRepository.deleteById(id);
        }
    }

    }

