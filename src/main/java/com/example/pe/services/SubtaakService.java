package com.example.pe.services;

import com.example.pe.model.DTO.SubtaakDTO;
import org.springframework.data.jpa.repository.Query;

public interface SubtaakService {
    void addSubtask (SubtaakDTO subtaakDTO);
}
