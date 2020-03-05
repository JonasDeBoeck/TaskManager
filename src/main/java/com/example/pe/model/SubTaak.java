package com.example.pe.model;

import javax.validation.constraints.NotEmpty;

public class SubTaak {
    @NotEmpty
    private String naam, description;
    private boolean done;

    public SubTaak(String naam, String description) {
        setNaam(naam);
        setDescription(description);
        done = false;
    }

    public SubTaak() {}

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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
