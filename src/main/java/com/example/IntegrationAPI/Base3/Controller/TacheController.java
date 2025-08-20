package com.example.IntegrationAPI.Base3.Controller;

import com.example.IntegrationAPI.Base3.Service.TacheService;
import com.example.IntegrationAPI.Base3.Service.TicketService;
import com.example.IntegrationAPI.Base3.model.Projet;
import com.example.IntegrationAPI.Base3.model.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/B3/tache")
@CrossOrigin(origins = "http://localhost:4200")
public class TacheController {

    @Autowired
    private TacheService transformationService;

    @PostMapping("/transform")
    public ResponseEntity<String> transform() {
        transformationService.migrerEmployees();
        return ResponseEntity.ok("Transformation terminée.");
    }
    // afficher ALLL
    @GetMapping
    public List<Tache> getAll() {
        return transformationService.getAllEmployees();
    }
    // Ajouter
    @PostMapping
    public Tache create(@RequestBody Tache empl) {
        return transformationService.save(empl);
    }

    // afficher par empCode
    @GetMapping("/{empCode}")
    public ResponseEntity<List<Tache>> getCongeByCode(@PathVariable("empCode") String empCode) {
        List<Tache> empl = transformationService.getEmployeeById(empCode);

        if (empl.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(empl);
    }

    //Modifier
    @PutMapping("/{empCode}")
    public Tache updateByEmpCode(@PathVariable String empCode, @RequestBody Tache updatedData) {
        return transformationService.updateByEmpCode(empCode, updatedData);
    }
//supprimer


    @DeleteMapping("/{empCode}")
    public void deleteByEmpCode(@PathVariable String empCode) {
        transformationService.deleteByEmpCode(empCode);
    }


}

