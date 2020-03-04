package com.example.pe.services;

import com.example.pe.model.Taak;

import java.time.LocalDateTime;
import java.util.List;

public interface TaakService {
    List<Taak> getTaken();
    Taak getTaak(int id);
    void addTask(Taak taak);
    int getLastId();
    void editTaak(String naam, String description, LocalDateTime localDateTime, int id);
    void addSubtaak(Taak taak, int id);
    List<Taak> getSubtaken (int id);
}
