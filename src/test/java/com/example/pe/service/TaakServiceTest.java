package com.example.pe.service;

import com.example.pe.formatters.TaakFormatter;
import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.model.Taak;
import com.example.pe.services.SubtaakServiceImpl;
import com.example.pe.services.TaakServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TaakServiceTest {

    @Autowired
    private TaakServiceImpl taakService;
    @Autowired
    private SubtaakServiceImpl subtaakService;

    @BeforeEach
    public void setUp() {
        TaakDTO taakDTO = new TaakDTO();
        taakDTO.setNaam("Task1");
        taakDTO.setDescription("Lorum Ipsum");
        taakDTO.setDatum(LocalDateTime.of(2020,3,10,10,0));
        taakService.addTask(taakDTO);
    }

    @Test
    public void testGetTaak() {
        assertNotNull(TaakFormatter.dtoToTaak(taakService.getTaak(taakService.getTaken().get(0).getId())));
    }

    @Test
    public void testAddTask() {
        TaakDTO taakDTO = new TaakDTO();
        taakDTO.setNaam("Test");
        taakDTO.setDescription("Lorum Ipsum");
        taakDTO.setDatum(LocalDateTime.of(2020,3,10,10,0));
        taakService.addTask(taakDTO);
        assertEquals(2, taakService.getTaken().size());
        assertEquals(TaakFormatter.dtoToTaak(taakDTO), TaakFormatter.dtoToTaak(taakService.getTaak(taakService.getTaken().get(taakService.getTaken().size()-1).getId())));
    }

   @Test
    public void testEditTask() {
        TaakDTO taakDTO = new TaakDTO();
        taakDTO.setId(taakService.getTaken().get(0).getId());
        taakDTO.setDescription("Aangepast");
        taakDTO.setNaam("Aangepast");
        taakDTO.setDatum(LocalDateTime.of(2021,3,10,10,0));
        taakService.editTaak(taakDTO);
        assertEquals(TaakFormatter.dtoToTaak(taakService.getTaken().get(0)), TaakFormatter.dtoToTaak(taakDTO));
    }

    @Test
    public void testGetSubtaken() {
        SubtaakDTO subtaakDTO = new SubtaakDTO();
        subtaakDTO.setNaam("Test");
        subtaakDTO.setDescription("Test");
        subtaakDTO.setDone(false);
        subtaakDTO.setId(taakService.getTaken().get(0).getId());
        subtaakService.addSubtask(subtaakDTO);
        assertFalse(taakService.getSubtaken(taakService.getTaken().get(0).getId()).isEmpty());
        assertEquals(taakService.getSubtaken(taakService.getTaken().get(0).getId()).size(), 1);
        subtaakService.addSubtask(subtaakDTO);
        assertEquals(taakService.getSubtaken(taakService.getTaken().get(0).getId()).size(), 2);
    }

    @Test
    public void testSearchTask() {
        List<Taak> notempty = TaakFormatter.dtoListToTaakList(taakService.searchTaak("Task1"));
        List<Taak> empty = TaakFormatter.dtoListToTaakList(taakService.searchTaak("NULL"));
        assertNotNull(notempty);
        assertFalse(notempty.isEmpty());
        assertEquals(1, notempty.size());
        assertNotNull(empty);
        assertTrue(empty.isEmpty());
        assertEquals(0, empty.size());
    }

    @Test
    public void testGetTaken() {
        List<Taak> taken = TaakFormatter.dtoListToTaakList(taakService.getTaken());
        assertNotNull(taken);
        assertFalse(taken.isEmpty());
        assertEquals(1, taken.size());
        Taak taak = taken.get(0);
        assertNotNull(taak);
    }

    @Test
    public void testRemoveTask() {
        taakService.removeTaak(taakService.getTaken().get(0).getId());
        assertTrue(taakService.getTaken().isEmpty());
    }

    @AfterEach
    public void delete() {
        taakService.clearRepo();
    }
}
