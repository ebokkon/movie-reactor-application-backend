package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Room;
import com.codecool.moviereactorapplication.model.Seat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatCreator {

    public List<Seat> createSeatsForRoom(Room room) {
        List<Seat> seats = new ArrayList<>();
        System.out.println("Create seats with " + room.getNumberOfRows() + " rows and " + room.getNumberOfSeatsPerRow() + " seats per row");
        System.out.println(room.toString());
        int seatId = 0;
        for (int row = 1; row < room.getNumberOfRows()+1; row++) {
            for (int seatNu = 1; seatNu < room.getNumberOfSeatsPerRow()+1; seatNu++) {
                Seat newSeat = new Seat(seatId, row, seatNu, room);
                seats.add(newSeat);
                seatId++;
            }
        }
        return seats;
    }

}
