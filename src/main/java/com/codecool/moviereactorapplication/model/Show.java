package com.codecool.moviereactorapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {
    private Integer id;
    private LocalDateTime showtime;
    private Room room;

}
