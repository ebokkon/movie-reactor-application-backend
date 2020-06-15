package com.codecool.moviereactorapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {
    private Integer id;
    private LocalDate startingDate;
    private LocalTime startingTime;
    private Movie movie;
    private Room room;
}