package com.example.pe.services;

import com.example.pe.model.Taak;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class TaakServiceImpl implements TaakService{
    private List<Taak> taken;

    public TaakServiceImpl() {
        taken = new ArrayList<>();
        taken.add(new Taak("Task1", LocalDateTime.of(LocalDate.of(2020, 3, 20), LocalTime.of(10,0,0)), "Lorem ipsum dolor amet et", "Lorem ipsum dolor sit amet et", 1));
        taken.add(new Taak("Task2", LocalDateTime.of(LocalDate.of(2020, 3, 21), LocalTime.of(18,0,0)), "Lorem ipsum dolor amet et", "Lorem ipsum dolor sit amet et", 1));
        taken.add(new Taak("Task3", LocalDateTime.of(LocalDate.of(2020, 3, 27), LocalTime.of(17,0,0)), "Lorem ipsum dolor amet et", "Lorem ipsum dolor sit amet et", 1));
    }

    public Taak getTaak(int id) {
        for (Taak taak : taken) {
            if (id == taak.getId()) {
                return taak;
            }
        }
        return null;
    }

    public List<Taak> getTaken() {
        return taken;
    }
}
