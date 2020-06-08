package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Room;
import com.codecool.moviereactorapplication.model.Seat;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatStorage {
    private SeatCreator seatCreator;
    private @Getter List<Seat> seatStorage = new ArrayList<>();

    @Autowired
    public SeatStorage(SeatCreator seatCreator, RoomStorage roomStorage) {
        this.seatCreator = seatCreator;

        for (Room room : roomStorage.getRoomStorage()) {
            seatStorage = seatCreator.createSeatsForRoom(room);
        }
    }

    public List<Seat> getSeatsByRoomId(int roomId) {
        List<Seat> seats = new ArrayList<>();

        for (Seat seat : seatStorage) {
            if (seat.getRoom().getId() == roomId) {
                seats.add(seat);
            }
        }
        return seats;
    }

    public int getNumberOfSeatsByRoomId(int roomId) {
        List<Seat> seats = getSeatsByRoomId(roomId);
        return seats.size();
    }
}
