package com.example.pe.formatters;

import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.model.SubTaak;
import com.example.pe.model.Taak;

import java.util.ArrayList;
import java.util.List;

public class SubtaakFormatter {

    public static SubtaakDTO subtaakToDTO(SubTaak subTaak) {
        SubtaakDTO subtaakDTO = new SubtaakDTO();
        subtaakDTO.setNaam(subTaak.getNaam());
        subtaakDTO.setDescription(subTaak.getDescription());
        subtaakDTO.setId(subTaak.getId());
        return subtaakDTO;
    }

    public static SubTaak dtoToSubtaak (SubtaakDTO subtaakDTO) {
        SubTaak subTaak = new SubTaak(subtaakDTO.getNaam(), subtaakDTO.getDescription(), subtaakDTO.getTaak());
        subTaak.setId(subtaakDTO.getId());
        return subTaak;
    }

    public static List<SubTaak> dtoListToSubtaakList (List<SubtaakDTO> subtaakDTOS) {
        List<SubTaak> subtaken = new ArrayList<>();
        for (SubtaakDTO subtaakDTO : subtaakDTOS) {
            subtaken.add(dtoToSubtaak(subtaakDTO));
        }
        return subtaken;
    }

    public static List<SubtaakDTO> subtaakListToDtoList (List<SubTaak> subtaken) {
        List<SubtaakDTO> subtaakDTOS = new ArrayList<>();
        for (SubTaak subTaak : subtaken) {
            subtaakDTOS.add(subtaakToDTO(subTaak));
        }
        return subtaakDTOS;
    }
}
