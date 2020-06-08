package com.codecool.moviereactorapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Room {
    private int id;
    private String name;
    // TODO: will be a transient field in JPA, calculated by the number of rows and seats per row
//    private int capacity;
    private int numberOfRows;
    private int numberOfSeatsPerRow;

}
