package com.example.pe.services;

import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.model.SubTaak;
import com.example.pe.model.Taak;

import java.util.List;

public interface TaakService {
    List<Taak> getTaken();
    Taak getTaak(long id);
    void addTask(TaakDTO taak);
    void editTaak(TaakDTO taak);
    List<SubTaak> getSubtaken (long id);
    List<Taak> searchTaak (String naam);
}
