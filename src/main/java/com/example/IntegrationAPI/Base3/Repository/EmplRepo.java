package com.example.IntegrationAPI.Base3.Repository;


import com.example.IntegrationAPI.Base3.model.Empl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplRepo extends JpaRepository<Empl, Long> {
}
