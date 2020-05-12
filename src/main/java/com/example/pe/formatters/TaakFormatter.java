package com.example.pe.formatters;

import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.model.Taak;

import java.util.ArrayList;
import java.util.List;

public class TaakFormatter {

    public static TaakDTO taakToDTO(Taak taak) {
        TaakDTO taakDTO = new TaakDTO();
        taakDTO.setDatum(taak.getDatum());
        taakDTO.setNaam(taak.getNaam());
        taakDTO.setDescription(taak.getDescription());
        taakDTO.setId(taak.getId());
        return taakDTO;
    }

    public static Taak dtoToTaak (TaakDTO taakDTO) {
        Taak taak = new Taak(taakDTO.getNaam(), taakDTO.getDatum(), taakDTO.getDescription());
        taak.setId(taakDTO.getId());
        return taak;
    }

    public static List<Taak> dtoListToTaakList (List<TaakDTO> taakDTOS) {
        List<Taak> taken = new ArrayList<>();
        for (TaakDTO taakDTO : taakDTOS) {
            taken.add(dtoToTaak(taakDTO));
        }
        return taken;
    }

    public static List<TaakDTO> taakListToDtoList (List<Taak> taken) {
        List<TaakDTO> taakDTOS = new ArrayList<>();
        for (Taak taak : taken) {
            taakDTOS.add(taakToDTO(taak));
        }
        return taakDTOS;
    }
}
