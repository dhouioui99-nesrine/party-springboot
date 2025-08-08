package com.example.IntegrationAPI.Base3.Service;


import com.example.IntegrationAPI.Base3.Repository.ProjetRepository;
import com.example.IntegrationAPI.Base3.model.Projet;
import com.example.IntegrationAPI.MySql.Repository.ProjectRepository;
import com.example.IntegrationAPI.MySql.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjetRepository projetRepository;



    public void migrerEmployees() {
        List<Project> employees = projectRepository.findAll();

        for (Project emp : employees) {
            Projet newEmp = new Projet();

            newEmp.setName(emp.getName());
            newEmp.setDescription(emp.getDescription());
            newEmp.setStatus(emp.getStatus());


            projetRepository.save(newEmp);
        }
    }
}
