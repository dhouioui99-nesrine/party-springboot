package com.example.IntegrationAPI.Base3.Service;


import com.example.IntegrationAPI.Base3.Repository.ProjetRepository;
import com.example.IntegrationAPI.Base3.model.Empl;
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

    public List<Projet> getAllEmployees() {

        return  projetRepository.findAll();
    }

    // create
    public Projet save(Projet empl) {
        return projetRepository.save(empl);
    }
    //delete  par empcode
    public void deleteByEmpCode(String empCode) {
        List<Projet> empl = projetRepository.findByEmpCode(empCode);
        if (empl.isEmpty()) {
            throw new RuntimeException("No employee found with empCode: " + empCode);
        }
        for (Projet empls : empl) {
            projetRepository.delete(empls);
        }
    }


    // update  par empcode
    public Projet updateByEmpCode(String empCode, Projet updatedData) {
        Projet empl = projetRepository.findFirstByEmpCode(empCode)
                .orElseThrow(() -> new RuntimeException("employe not found with empCode: " + empCode));

        empl.setName(updatedData.getName());
        empl.setDescription(updatedData.getDescription());
        empl.setStatus(updatedData.getStatus());


        return projetRepository.save(empl);
    }
    // afficher les conges par empCode
    public List<Projet> getEmployeeById(String empCode) {
        return projetRepository.findByEmpCode(empCode);
    }

}

