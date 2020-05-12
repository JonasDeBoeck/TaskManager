package com.example.pe.rest;

import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.services.SubtaakService;
import com.example.pe.services.TaakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SubtaakRestController {

    private final SubtaakService subtaakService;

    @Autowired
    public SubtaakRestController (SubtaakService subtaakService) {
        this.subtaakService = subtaakService;
    }

    @PostMapping("/tasks/{id}/sub/create")
    public SubtaakDTO addSubtaak(@RequestBody @ModelAttribute @Valid SubtaakDTO subtaakDTO) {
        return subtaakService.addSubtask(subtaakDTO);
    }
}
