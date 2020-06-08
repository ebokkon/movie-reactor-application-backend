package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Seat;
import com.codecool.moviereactorapplication.model.SeatReserved;
import com.codecool.moviereactorapplication.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class SeatReservedCreator {

    //    private RoomStorage roomStorage;
    private SeatStorage seatStorage;
    private ShowStorage showStorage;
    List<SeatReserved> reservedSeats = new ArrayList<>();
    private Random random = new Random();
    private static int index = 0;

    @Autowired
    public SeatReservedCreator(SeatStorage seatStorage, ShowStorage showStorage) {
        this.seatStorage = seatStorage;
        this.showStorage = showStorage;
    }

    public List<SeatReserved> createReservedSeats() {
        for (Show show : showStorage.getShows()) {
            int roomId = show.getRoom().getId();
            List<Seat> seats = seatStorage.getSeatsByRoomId(roomId);

            for (Seat seat : seats) {
                if (random.nextBoolean()) {
                    SeatReserved newReservedSeat = new SeatReserved(index, seat, show);
                    reservedSeats.add(newReservedSeat);
                    index++;
                }
            }
        }
        return reservedSeats;
    }
}
