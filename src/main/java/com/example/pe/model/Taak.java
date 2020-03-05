package com.example.pe.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Taak {
    @NotEmpty
    private String naam, description;
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private LocalDateTime datum;
    private int id;
    private List<SubTaak> subtaken;

    public Taak (String naam, LocalDateTime datum, String description) {
        setNaam(naam);
        setDatum(datum);
        setDescription(description);
        subtaken = new ArrayList<>();
    }

    public Taak() {}

    public void setNaam(String naam) {
            this.naam = naam;
    }

    public void setDatum(LocalDateTime datum) {
            this.datum = datum;
    }

    public void setDescription(String description) {
            this.description = description;
    }

    public void addSubTaak(SubTaak subTaak) {
        subtaken.add(subTaak);
    }

    public List<SubTaak> getSubtaken() {
        return subtaken;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDateTime getDatum() {
        return datum;
    }
}
