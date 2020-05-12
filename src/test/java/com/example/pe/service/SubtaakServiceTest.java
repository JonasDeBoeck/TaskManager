package com.example.pe.service;

import com.example.pe.formatters.SubtaakFormatter;
import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.services.SubtaakServiceImpl;
import com.example.pe.services.TaakServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

@SpringBootTest
public class SubtaakServiceTest {

    @Autowired
    private TaakServiceImpl taakService;
    @Autowired
    private SubtaakServiceImpl subtaakService;

    TaakDTO taakDTO;
    SubtaakDTO subtaakDTO;

    @BeforeEach
    public void setUp() {
        taakDTO = new TaakDTO();
        taakDTO.setNaam("Task1");
        taakDTO.setDescription("Lorum Ipsum");
        taakDTO.setDatum(LocalDateTime.of(2020,3,10,10,0));
        taakService.addTask(taakDTO);
        subtaakDTO = new SubtaakDTO();
        subtaakDTO.setNaam("Test");
        subtaakDTO.setDescription("Test");
        subtaakDTO.setId(taakService.getTaken().get(0).getId());
    }

    @Test
    public void testAddSubtask() {
        subtaakService.addSubtask(subtaakDTO);
        assertEquals(taakService.getSubtaken(taakService.getTaken().get(0).getId()).size(), 1);
        assertEquals(SubtaakFormatter.dtoToSubtaak(subtaakDTO), SubtaakFormatter.dtoToSubtaak(taakService.getSubtaken(taakService.getTaken().get(0).getId()).get(0)));
    }

    @AfterEach
    public void delete() {
        subtaakService.clearRepo();
    }
}
