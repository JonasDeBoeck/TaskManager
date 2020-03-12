package com.example.pe.model.DTO;

import javax.validation.constraints.NotEmpty;

public class SubtaakDTO {
    @NotEmpty
    private String naam, description;
    private long id;

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
}
