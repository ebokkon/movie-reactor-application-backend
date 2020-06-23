package com.codecool.moviereactorapplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Seat {
    @Id
    @GeneratedValue
    private Long id;

    private Integer rowNumber;

    private Integer seatNumber;

    @ManyToOne
    //@EqualsAndHashCode.Exclude
    @JsonBackReference
    private Room room;

    @OneToOne
    private SeatReserved seatReserved;
}
