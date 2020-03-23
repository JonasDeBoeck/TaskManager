package com.example.pe;

import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.model.Taak;
import com.example.pe.services.TaakServiceImpl;
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

    @Test
    public void testGetTaken() {
        TaakDTO taakDTO = new TaakDTO();
        taakDTO.setNaam("Task1");
        taakDTO.setDescription("Lorum Ipsum");
        taakDTO.setDatum(LocalDateTime.of(2020,3,10,10,0));
        taakService.addTask(taakDTO);

        List<Taak> taken = taakService.getTaken();

        assertNotNull(taken);
        assertFalse(taken.isEmpty());
        assertEquals(1, taken.size());
        Taak taak = taken.get(0);
        assertNotNull(taak);
    }
}
