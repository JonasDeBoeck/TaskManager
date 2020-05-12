package com.example.pe.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Taak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String naam, description;
    @NotNull
    private LocalDateTime datum;
    @OneToMany(mappedBy = "taak", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SubTaak> subtaken;

    public Taak (String naam, LocalDateTime datum, String description) {
        setNaam(naam);
        setDatum(datum);
        setDescription(description);
        subtaken = new ArrayList<>();
    }

    public Taak() {}

    @Override
    public boolean equals (Object o) {
        boolean eq = false;
        if (o instanceof Taak) {
            Taak taak = (Taak) o;
            if (taak.naam.equals(this.naam) && taak.description.equals(this.description) && taak.datum.equals(this.datum)) {
                eq = true;
            }
        }
        return eq;
    }

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

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDateTime getDatum() {
        return datum;
    }
}
