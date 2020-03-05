package com.example.pe.services;

import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.model.SubTaak;
import com.example.pe.model.Taak;

import java.util.List;

public interface TaakService {
    List<Taak> getTaken();
    Taak getTaak(int id);
    void addTask(Taak taak);
    int getLastId();
    void editTaak(Taak taak);
    void addSubtaak(SubtaakDTO taak);
    List<SubTaak> getSubtaken (int id);
    List<Taak> searchTaak (String naam);
}
