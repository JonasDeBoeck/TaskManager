package com.example.pe.model;

import java.time.LocalDateTime;

public class Taak {
    private String naam, description;
    private LocalDateTime datum;
    private int id;

    public Taak (String naam, LocalDateTime datum, String description, int id) {
        setNaam(naam);
        setDatum(datum);
        setDescription(description);
        setId(id);
    }

    public Taak () {

    }

    private void setNaam(String naam) {
        if (naam.trim().isEmpty()) {
            throw new IllegalArgumentException("Naam moet ingevuld zijn!");
        } else {
            this.naam = naam;
        }
    }

    private void setDatum(LocalDateTime datum) {
        if (datum == null) {
            throw new IllegalArgumentException("Geef een datum op!");
        } else {
            this.datum = datum;
        }
    }

    private void setDescription(String description) {
        if (description.trim().isEmpty()) {
            throw new IllegalArgumentException("Geef een beschrijving op!");
        } else {
            this.description = description;
        }
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

    public String getHours () {
        if (datum.getHour() > 12) {
            return datum.getHour() - 12 + " PM";
        } else {
            return datum.getHour() + " AM";
        }
    }

    public String getNaam() {
        return naam;
    }

    public LocalDateTime getDatum() {
        return datum;
    }
}
