package com.codecool.moviereactorapplication.entity;

import com.codecool.moviereactorapplication.entity.Seat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // TODO: Should create a transient field capacity, calculated by the number of rows and seats per row.

    private Integer numberOfRows;
    private Integer numberOfSeatsPerRow;
    private Integer capacity;

    public void setCapacity () {
        if (numberOfRows != null && numberOfSeatsPerRow != null) {
            this.capacity = numberOfRows * numberOfSeatsPerRow;
        }
    }

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Seat> seats;

    /*public Room() {
        this.capacity = numberOfRows * numberOfSeatsPerRow;
    }*/
}
