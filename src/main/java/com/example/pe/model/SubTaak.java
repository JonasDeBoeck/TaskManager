package com.example.pe.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class SubTaak {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty (message = "Name can not be empty!")
    private String naam;
    @NotEmpty (message = "Description can not be empty!")
    private String description;
    private boolean done;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Taak taak;

    public SubTaak(String naam, String description, Taak taak) {
        setNaam(naam);
        setDescription(description);
        done = false;
        setTaak(taak);
    }

    public boolean equals (Object o) {
        boolean eq = false;
        if (o instanceof SubTaak) {
            SubTaak subTaak = (SubTaak) o;
            if (subTaak.naam.equals(this.naam) && subTaak.description.equals(this.description)) {
                eq = true;
            }
        }
        return eq;
    }

    public SubTaak() {
        done = false;
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Taak getTaak() {
        return taak;
    }

    public void setTaak(Taak taak) {
        this.taak = taak;
    }
}
