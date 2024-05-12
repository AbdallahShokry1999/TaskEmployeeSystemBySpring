package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Projects;
import com.example.demo.repo.ProjectRepository;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Projects> getAllProjects() {
        return projectRepository.findAll();
    }

    public Projects getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void addProject(Projects project) {
        projectRepository.save(project);
    }

    public void updateProject(Projects project) {
        projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
