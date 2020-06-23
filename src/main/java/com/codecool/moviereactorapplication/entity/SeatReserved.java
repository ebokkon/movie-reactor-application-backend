package com.codecool.moviereactorapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SeatReserved {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Seat seat;

    @ManyToOne
    private Show show;
}
