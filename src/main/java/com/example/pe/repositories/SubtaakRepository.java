package com.example.pe.repositories;

import com.example.pe.model.SubTaak;
import com.example.pe.model.Taak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface SubtaakRepository extends JpaRepository<SubTaak, Long> {
    List<SubTaak> findByTaak(Taak taak);
}
