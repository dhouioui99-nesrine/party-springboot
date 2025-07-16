package com.example.IntegrationAPI.Base3.Controller;

import com.example.IntegrationAPI.Base3.Service.CongeService;
import com.example.IntegrationAPI.Base3.Service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dep")
@CrossOrigin(origins = "http://localhost:4200")
public class DepController {
    @Autowired
    private DepService transformationService;

    @PostMapping("/transform")
    public ResponseEntity<String> transform() {
        transformationService.migrerDepartements();
        return ResponseEntity.ok("Transformation terminée.");
    }

}
