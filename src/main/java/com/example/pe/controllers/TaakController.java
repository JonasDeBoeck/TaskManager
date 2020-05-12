package com.example.pe.controllers;

import com.example.pe.formatters.SubtaakFormatter;
import com.example.pe.formatters.TaakFormatter;
import com.example.pe.model.DTO.SubtaakDTO;
import com.example.pe.model.DTO.TaakDTO;
import com.example.pe.model.Taak;
import com.example.pe.services.SubtaakService;
import com.example.pe.services.TaakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaakController {
    private TaakService taakService;
    private SubtaakService subtaakService;

    @Autowired
    public TaakController (TaakService taakService, SubtaakService subtaakService) {
        this.taakService = taakService;
        this.subtaakService = subtaakService;
    }

    @GetMapping("/tasks")
    public String showTasks (Model model) {
        model.addAttribute("tasks", TaakFormatter.dtoListToTaakList(taakService.getTaken()));
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String showTaskDetails (Model model, @PathVariable("id") int id) {
        model.addAttribute("task", TaakFormatter.dtoToTaak(taakService.getTaak(id)));
        model.addAttribute("subtaken", SubtaakFormatter.dtoListToSubtaakList(taakService.getSubtaken(id)));
        return "taskDetails";
    }

    @GetMapping("/tasks/new")
    public String showAddTask(Model model) {
        TaakDTO taak = new TaakDTO();
        model.addAttribute("taak", taak);
        return "addTask";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute("taak") @Valid TaakDTO taak, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "addTask";
        }
        taakService.addTask(taak);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String showEditTask (Model model, @PathVariable("id") int id) {
        TaakDTO taak = new TaakDTO();
        taak.setId(id);
        taak.setDescription(taakService.getTaak(id).getDescription());
        taak.setNaam(taakService.getTaak(id).getNaam());
        taak.setDatum(taakService.getTaak(id).getDatum());
        model.addAttribute("taak", taak);
        return "editTask";
    }

    @PostMapping("/tasks/edit")
    public String editTask (@ModelAttribute("taak") @Valid TaakDTO taak, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editTask";
        }
        taakService.editTaak(taak);
        return "redirect:/tasks/" + taak.getId();
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String showAddSubtask(Model model, @PathVariable("id") int id) {
        model.addAttribute("task", taakService.getTaak(id));
        SubtaakDTO taak = new SubtaakDTO();
        taak.setId(id);
        model.addAttribute("taak", taak);
        return "createSubtask";
    }

    @PostMapping("/tasks/sub/create")
    public String addSubtask(@ModelAttribute @Valid SubtaakDTO taak, BindingResult bindingResult, Model model) {
        model.addAttribute("task", taakService.getTaak(taak.getId()));
        model.addAttribute("taak", taak);
        if (bindingResult.hasErrors()) {
            return "createSubtask";
        }
        subtaakService.addSubtask(taak);
        return "redirect:/tasks/" + taak.getId();
    }

    @GetMapping("/tasks/search")
    public String searchTask (Model model, @RequestParam(name = "naam")String naam) {
        model.addAttribute("gevonden", TaakFormatter.dtoListToTaakList(taakService.searchTaak(naam)));
        return "searchResultaat";
    }
}
