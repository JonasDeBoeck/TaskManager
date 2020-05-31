package com.example.pe.services;

import com.example.pe.formatters.TaakFormatter;
import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.model.SubTaak;
import com.example.pe.model.Taak;
import com.example.pe.repositories.SubtaakRepository;
import com.example.pe.repositories.TaakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        TaakDTO taakDTO = new TaakDTO();
        taakDTO.setNaam("Test");
        taakDTO.setDatum(LocalDateTime.of(2020, 2, 4, 12, 13));
        taakDTO.setDescription("Test");
        addTask(taakDTO);
    }

    public TaakDTO getTaak(long id) {
        Optional<Taak> taakOptional = taakRepository.findById(id);
        Taak taak = new Taak();
        taak.setId(-13);
        return TaakFormatter.taakToDTO(taakOptional.orElse(taak));
    }

    @Override
    public TaakDTO addTask(TaakDTO wegwerp) {
        Taak taak = new Taak();
        taak.setNaam(wegwerp.getNaam());
        taak.setDescription(wegwerp.getDescription());
        taak.setDatum(wegwerp.getDatum());
        taakRepository.save(taak);
        return wegwerp;
    }

    @Override
    public TaakDTO editTaak(TaakDTO wegwerp) {
        taakRepository.editTaak(wegwerp.getNaam(), wegwerp.getDescription(), wegwerp.getDatum(), wegwerp.getId());
        return wegwerp;
    }

    @Override
    public List<SubtaakDTO> getSubtaken(long id) {
        Taak taak = TaakFormatter.dtoToTaak(getTaak(id));
        List<SubtaakDTO> subtaken = new ArrayList<>();
        for (SubTaak subTaak : subtaakRepository.findByTaak(taak)) {
            SubtaakDTO subtaakDTO = new SubtaakDTO();
            subtaakDTO.setNaam(subTaak.getNaam());
            subtaakDTO.setId(subTaak.getId());
            subtaakDTO.setDescription(subTaak.getDescription());
            subtaakDTO.setDone(subTaak.isDone());
            subtaken.add(subtaakDTO);
        }
        return subtaken;
    }

    @Override
    public List<TaakDTO> searchTaak(String naam) {
        List<TaakDTO> taken = new ArrayList<>();
        for (Taak taak : taakRepository.findByNaam(naam)) {
            taken.add(TaakFormatter.taakToDTO(taak));
        }
        return taken;
    }

    public List<TaakDTO> getTaken() {
        List<TaakDTO> taken = new ArrayList<>();
        List<Taak> repo = taakRepository.findAll();
        for (Taak taak : repo) {
            taken.add(TaakFormatter.taakToDTO(taak));
        }
        return taken;
    }

    @Override
    public TaakDTO removeTaak(long id) {
        TaakDTO taakDTO = getTaak(id);
        taakRepository.deleteById(id);
        return taakDTO;
    }

    public void clearRepo() {
        taakRepository.deleteAll();
    }
}
