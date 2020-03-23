package com.example.pe.services;

import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.model.SubTaak;
import com.example.pe.model.Taak;
import com.example.pe.repositories.SubtaakRepository;
import com.example.pe.repositories.TaakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class TaakServiceImpl implements TaakService{
    private TaakRepository taakRepository;
    private SubtaakRepository subtaakRepository;

    @Autowired
    public TaakServiceImpl(TaakRepository taakRepository, SubtaakRepository subtaakRepository) {
        this.taakRepository = taakRepository;
        this.subtaakRepository = subtaakRepository;
    }

    public Taak getTaak(long id) {
        Optional<Taak> taakOptional = taakRepository.findById(id);
        return taakOptional.orElse(null);
    }

    @Override
    public void addTask(TaakDTO wegwerp) {
        Taak taak = new Taak();
        taak.setNaam(wegwerp.getNaam());
        taak.setDescription(wegwerp.getDescription());
        taak.setDatum(wegwerp.getDatum());
        taakRepository.save(taak);
    }

    @Override
    public void editTaak(TaakDTO wegwerp) {
        taakRepository.editTaak(wegwerp.getNaam(), wegwerp.getDescription(), wegwerp.getDatum(), wegwerp.getId());
    }

    @Override
    public List<SubTaak> getSubtaken(long id) {
        Taak taak = getTaak(id);
        return subtaakRepository.findByTaak(taak);
    }

    @Override
    public List<Taak> searchTaak(String naam) {
        return taakRepository.findByNaam(naam);
    }

    public List<Taak> getTaken() {
        return taakRepository.findAll();
    }
}
