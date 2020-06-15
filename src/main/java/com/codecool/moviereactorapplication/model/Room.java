package com.codecool.moviereactorapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private int id;
    private String name;
    // TODO: will be a transient field in JPA, calculated by the number of rows and seats per row
    private int numberOfRows;
    private int numberOfSeatsPerRow;

}
