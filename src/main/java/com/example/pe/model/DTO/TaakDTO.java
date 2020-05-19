package com.example.pe.model.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


public class TaakDTO {
    @NotEmpty (message = "Name cannot be empty!")
    private String naam;
    @NotEmpty (message = "Description cannot be empty!")
    private String description;
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull (message = "Date cannot be empty!")
    private LocalDateTime datum;
    private long id;

    public TaakDTO() {}

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

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
