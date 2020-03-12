package com.example.pe.repositories;

import com.example.pe.model.Taak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Component
public interface TaakRepository extends JpaRepository<Taak, Long> {
    @Modifying
    @Transactional
    @Query("update Taak t set t.naam = ?1, t.description = ?2, t.datum = ?3 where t.id = ?4")
    void editTaak(String naam, String description, LocalDateTime datum, long id);

    List<Taak> findByNaam(String naam);
}
