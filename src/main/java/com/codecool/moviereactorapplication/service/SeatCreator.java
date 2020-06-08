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
        int seatId = 0;
        for (int row = 1; row < room.getNumberOfRows(); row++) {
            for (int seatNu = 1; seatNu < room.getNumberOfSeatsPerRow(); seatNu++) {
                Seat newSeat = new Seat(seatId, row, seatNu, room);
                seats.add(newSeat);
                seatId++;
            }
        }
        return seats;
    }

}
