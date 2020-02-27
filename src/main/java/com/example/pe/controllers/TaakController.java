package com.example.pe.controllers;

import com.example.pe.services.TaakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
