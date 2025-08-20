package com.example.IntegrationAPI.Base3.Repository;

import com.example.IntegrationAPI.Base3.model.Projet;
import com.example.IntegrationAPI.Base3.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {

    List<Tache> findByEmpCode(String empCode);
    Optional<Tache> findFirstByEmpCode(String empCode);
    boolean existsByEmpCode(String empCode);
    boolean existsByEmail (String email) ;
}
