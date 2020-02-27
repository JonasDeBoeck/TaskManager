package com.example.pe.services;

import com.example.pe.model.Taak;

import java.time.LocalDateTime;
import java.util.List;

public interface TaakService {
    List<Taak> getTaken();
    Taak getTaak(int id);
    void addTask(String titel, String description, String localDate);
    int getLastId();
}
