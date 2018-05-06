package com.example.journeyservice.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Journey {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull
    private String startLocation;

    //@NotNull
    private String finishLocation;

   // @NotNull
    private LocalDate date;

    private String name;

    public Journey() {
    }

    public Journey(String startLocation, String finishLocation, LocalDate date, Optional<String> name) {
        this.startLocation = startLocation;
        this.finishLocation = finishLocation;
        this.date = date;
        this.name = name.orElse("unmemorable bike ride");
    }

    public Long getId() {
        return id;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getFinishLocation() {
        return finishLocation;
    }

    public LocalDate getDate() {
        return date;
    }
}
