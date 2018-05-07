package com.example.journeyservice.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Entity
@NamedQuery(
        name = "Journey.findAll",
        query = "SELECT j FROM Journey j"
)
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotNull
    private String startLocation;

    @NotNull
    private String finishLocation;

    @NotNull
    private LocalDate date;

    private String name;

    public Journey() {
    }

    public Journey(String startLocation, String finishLocation, LocalDate date, String name) {
        this.startLocation = startLocation;
        this.finishLocation = finishLocation;
        this.date = date;
        this.name = name;
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

    @JsonProperty("date")
    public String getDateFormatted() {
        return date.format(DateTimeFormatter.ISO_DATE);
    }

    public String getName() {
        return Optional.ofNullable(name).orElse("not specified");
    }
}
