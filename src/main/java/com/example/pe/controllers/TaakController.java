package com.example.pe.controllers;

import com.example.pe.model.Taak;
import com.example.pe.services.TaakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaakController {
    private TaakService taakService;

    @Autowired
    public TaakController (TaakService taakService) {
        this.taakService = taakService;
    }

    @GetMapping("/tasks")
    public String showTasks (Model model) {
        model.addAttribute("tasks", taakService.getTaken());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String showTaskDetails (Model model, @PathVariable("id") int id) {
        model.addAttribute("task", taakService.getTaak(id));
        return "taskDetails";
    }

    @GetMapping("/tasks/new")
    public String showAddTask(Model model) {
        model.addAttribute("id", taakService.getLastId());
        return "addTask";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute Taak taak){
        taakService.addTask(taak);
        return "redirect:/tasks";
    }
}
