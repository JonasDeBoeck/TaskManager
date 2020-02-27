package com.example.pe.model;

import java.time.LocalDateTime;

public class Taak {
    private String naam, description, tijdVdDag;
    private LocalDateTime datum;
    private int id;

    public Taak (String naam, LocalDateTime datum, String description, int id) {
        setNaam(naam);
        setDatum(datum);
        setDescription(description);
        setId(id);
        setTijdVdDag();
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

    public void setDatum(LocalDateTime datum) {
        if (datum == null) {
            throw new IllegalArgumentException("Geef een datum op!");
        } else {
            this.datum = datum;
        }
    }

    private void setTijdVdDag () {
        if (datum.getHour() > 12) {
            this.tijdVdDag = "PM";
            setDatum(this.datum.minusHours(12));
        } else {
            this.tijdVdDag = "AM";
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

    public String getTijdVdDag () {
        return this.tijdVdDag;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDateTime getDatum() {
        return datum;
    }
}
