package com.codecool.moviereactorapplication.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Show {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "show", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<SeatReserved> reservedSeats;

    private LocalDate startingDate;
    private LocalTime startingTime;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Movie movie;
}
