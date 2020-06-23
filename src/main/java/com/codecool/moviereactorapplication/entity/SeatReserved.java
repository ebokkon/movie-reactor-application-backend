package com.codecool.moviereactorapplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
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

    @ManyToOne
    @JsonManagedReference
    private Seat seat;

    @ManyToOne
    @JsonBackReference
    private Show show;
}
