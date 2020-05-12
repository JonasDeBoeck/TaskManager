package com.example.pe.rest;

import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.services.TaakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaakRestController {

    private final TaakService taakService;

    @Autowired
    public TaakRestController (TaakService taakService) {
        this.taakService = taakService;
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<TaakDTO> getTasks () {
        return taakService.getTaken();
    }

    @GetMapping("/tasks/{id}")
    @ResponseBody
    public TaakDTO getTaak (@PathVariable long id) {
        return taakService.getTaak(id);
    }

    @GetMapping("/tasks/subtasks/{id}")
    @ResponseBody
    public List<SubtaakDTO> getSubtaken(@PathVariable long id) {
        return taakService.getSubtaken(id);
    }

    @GetMapping("/tasks/search/{naam}")
    @ResponseBody
    public List<TaakDTO> searchTaak(@PathVariable String naam) {
        return taakService.searchTaak(naam);
    }

    @PostMapping("/tasks/new")
    public TaakDTO createNewTask(@RequestBody @ModelAttribute @Valid TaakDTO taakDTO) {
        return taakService.addTask(taakDTO);
    }

    @PostMapping("/tasks/edit")
    public TaakDTO editTask(@RequestBody @ModelAttribute @Valid TaakDTO taakDTO) {
        return taakService.editTaak(taakDTO);
    }

    @PostMapping("/tasks/delete/{id}")
    public TaakDTO deleteTask(@PathVariable long id) {
        return taakService.removeTaak(id);
    }
}
