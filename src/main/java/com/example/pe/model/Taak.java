package com.example.pe.model;

import java.time.LocalDateTime;

public class Taak {
    private String naam;
    private LocalDateTime datum;

    public Taak (String naam, LocalDateTime datum) {
        setNaam(naam);
        setDatum(datum);
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
