package com.example.demo.repo;

import com.example.demo.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    void deleteByUserId(String userId); // Custom delete method based on user_id

}
