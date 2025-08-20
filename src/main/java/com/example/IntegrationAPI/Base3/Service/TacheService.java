package com.example.IntegrationAPI.Base3.Service;

import com.example.IntegrationAPI.Base3.Repository.TacheRepository;
import com.example.IntegrationAPI.Base3.Repository.TicketRepository;
import com.example.IntegrationAPI.Base3.model.Projet;
import com.example.IntegrationAPI.Base3.model.Tache;
import com.example.IntegrationAPI.Base3.model.Ticket;
import com.example.IntegrationAPI.MySql.Repository.IssuesRepository;
import com.example.IntegrationAPI.MySql.entity.Tracker;

import com.example.IntegrationAPI.MySql.entity.issues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheService {
    @Autowired
    private IssuesRepository issuesRepository;

    @Autowired
    private TacheRepository tacheRepository;



    public void migrerEmployees() {
        List<issues> employees = issuesRepository.findAll();

        for (issues emp : employees) {
            Tache newEmp = new Tache();
        newEmp.setTracker(emp.getTrackerId().getName());
            newEmp.setProject(emp.getProjectId().getName());
            newEmp.setSubject(emp.getSubject());
            newEmp.setDescription(emp.getDescription());
            newEmp.setStatuts(emp.getStatut().getName());
            newEmp.setDue_date(emp.getDue_date());
            newEmp.setStart_date(emp.getStart_date());
            if (emp.getAssigned() != null) {
                String firstname = emp.getAssigned().getFirstname() != null ? emp.getAssigned().getFirstname() : "";
                String lastname = emp.getAssigned().getLastname() != null ? emp.getAssigned().getLastname() : "";
                String fullname = (firstname + " " + lastname).trim();

                newEmp.setAssigned(fullname.isEmpty() ? "Nom inconnu" : fullname);
            } else {
                newEmp.setAssigned("Non assigné");
            }


            tacheRepository.save(newEmp);
        }
    }
    public List<Tache> getAllEmployees() {

        return  tacheRepository.findAll();
    }

    // create
    public Tache save(Tache empl) {
        return tacheRepository.save(empl);
    }
    //delete  par empcode
    public void deleteByEmpCode(String empCode) {
        List<Tache> empl = tacheRepository.findByEmpCode(empCode);
        if (empl.isEmpty()) {
            throw new RuntimeException("No employee found with empCode: " + empCode);
        }
        for (Tache empls : empl) {
            tacheRepository.delete(empls);
        }
    }


    // update  par empcode
    public Tache updateByEmpCode(String empCode, Tache updatedData) {
        Tache empl = tacheRepository.findFirstByEmpCode(empCode)
                .orElseThrow(() -> new RuntimeException("employe not found with empCode: " + empCode));

        empl.setTracker(updatedData.getTracker());
        empl.setProject(updatedData.getProject());
        empl.setDescription(updatedData.getDescription());
        empl.setStatuts(updatedData.getStatuts());
        empl.setSubject(updatedData.getSubject());
        empl.setDue_date(updatedData.getDue_date());
        empl.setStart_date(updatedData.getStart_date());
        empl.setAssigned(updatedData.getAssigned());


        return tacheRepository.save(empl);
    }
    // afficher les conges par empCode
    public List<Tache> getEmployeeById(String empCode) {
        return tacheRepository.findByEmpCode(empCode);
    }



}




