package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Projects;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {
}
