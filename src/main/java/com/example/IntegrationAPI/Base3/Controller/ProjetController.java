package com.example.IntegrationAPI.Base3.Controller;

import com.example.IntegrationAPI.Base3.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projet")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjetController {
    @Autowired
    private ProjectService transformationService;

    @PostMapping("/transform")
    public ResponseEntity<String> transform() {
        transformationService.migrerEmployees();
        return ResponseEntity.ok("Transformation terminée.");
    }

}

