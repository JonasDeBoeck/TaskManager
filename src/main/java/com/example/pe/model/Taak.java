package com.example.pe.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Taak {
    @NotEmpty
    private String naam, description;
    private String tijdVdDag;
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datum;
    private int id;
    private List<Taak> subtaken;

    public Taak (String naam, LocalDateTime datum, String description) {
        setNaam(naam);
        setDatum(datum);
        setDescription(description);
        setTijdVdDag();
        subtaken = new ArrayList<>();
    }

    public void setNaam(String naam) {
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

    public void setDescription(String description) {
        if (description.trim().isEmpty()) {
            throw new IllegalArgumentException("Geef een beschrijving op!");
        } else {
            this.description = description;
        }
    }

    public void addSubTaak(Taak taak) {
        subtaken.add(taak);
    }

    public List<Taak> getSubtaken() {
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
