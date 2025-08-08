package com.example.IntegrationAPI.Base3.Repository;

import com.example.IntegrationAPI.Base3.model.Empl;
import com.example.IntegrationAPI.Base3.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
}
