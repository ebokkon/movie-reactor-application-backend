package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Room;
import com.codecool.moviereactorapplication.model.Seat;
import com.codecool.moviereactorapplication.repository.SeatRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatCreator {
    private SeatRepository seatRepository;

    public SeatCreator(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public void createSeatsForRoomData(com.codecool.moviereactorapplication.entity.Room room) {
        System.out.println("Before stack overflow");
        for (int row = 1; row < room.getNumberOfRows()+1; row++) {
            for (int seatNu = 1; seatNu < room.getNumberOfSeatsPerRow()+1; seatNu++) {
                com.codecool.moviereactorapplication.entity.Seat newSeat = com.codecool.moviereactorapplication.entity.Seat.builder()
                        .rowNumber(row)
                        .seatNumber(seatNu)
                        .room(room)
                        .build();
                seatRepository.save(newSeat);
            }
        }
    }

    public List<Seat> createSeatsForRoom(Room room) {
        List<Seat> seats = new ArrayList<>();
        /*System.out.println("Create seats with " + room.getNumberOfRows() + " rows and " + room.getNumberOfSeatsPerRow() + " seats per row");
        System.out.println(room.toString());*/
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
