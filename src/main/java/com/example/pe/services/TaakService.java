package com.example.pe.services;

import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.model.SubTaak;
import com.example.pe.model.Taak;

import java.util.List;

public interface TaakService {
    List<TaakDTO> getTaken();
    TaakDTO getTaak(long id);
    TaakDTO addTask(TaakDTO taak);
    TaakDTO editTaak(TaakDTO taak);
    List<SubtaakDTO> getSubtaken (long id);
    List<TaakDTO> searchTaak (String naam);
    TaakDTO removeTaak(long id);
}
