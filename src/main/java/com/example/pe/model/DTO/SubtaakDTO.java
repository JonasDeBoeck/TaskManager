package com.example.pe.model.DTO;

import com.example.pe.model.Taak;

import javax.validation.constraints.NotEmpty;

public class SubtaakDTO {
    @NotEmpty (message = "Name can not be empty!")
    private String naam;
    @NotEmpty (message = "Description can not be empty!")
    private String description;
    private long id;
    private boolean isDone;
    private Taak taak;

    public SubtaakDTO() {}

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Taak getTaak() {
        return taak;
    }

    public void setTaak(Taak taak) {
        this.taak = taak;
    }
}
