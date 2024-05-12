package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query("SELECT e.id, e.name FROM Employee e WHERE e.id = :employeeId")
    Object[] findEmployeeTwoCById(Long employeeId);


    @Query("SELECT e.id, e.name FROM Employee e")
    List<Object[]> findAllEmployeeTwoC();
}

