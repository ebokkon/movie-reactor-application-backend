package com.codecool.moviereactorapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class Show {
    private Integer id;
    private LocalDateTime showtime;
    private Room room;

}
