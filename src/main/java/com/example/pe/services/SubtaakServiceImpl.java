package com.example.pe.services;

import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.SubTaak;
import com.example.pe.repositories.RepoException;
import com.example.pe.repositories.SubtaakRepository;
import com.example.pe.repositories.TaakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class SubtaakServiceImpl implements SubtaakService {
    private SubtaakRepository subtaakRepository;
    private TaakRepository taakRepository;

    @Autowired
    public SubtaakServiceImpl(SubtaakRepository subtaakRepository, TaakRepository taakRepository) {
        this.subtaakRepository = subtaakRepository;
        this.taakRepository = taakRepository;
    }

    @Override
    public SubtaakDTO addSubtask(SubtaakDTO subtaakDTO) {
        SubTaak subtaak = new SubTaak();
        subtaak.setNaam(subtaakDTO.getNaam());
        subtaak.setDescription(subtaakDTO.getDescription());
        subtaak.setTaak(taakRepository.findById(subtaakDTO.getId()).orElse(null));
        taakRepository.findById(subtaakDTO.getId()).map(post -> subtaakRepository.save(subtaak)).orElseThrow(() -> new RepoException("Taak niet gevonden"));
        return subtaakDTO;
    }

    public void clearRepo() {
        subtaakRepository.deleteAll();
    }
}
