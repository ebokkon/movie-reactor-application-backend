package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.SeatReserved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatReservedStorage {
    private final List<SeatReserved> seatReservedStorage;

    public SeatReservedStorage(SeatReservedCreator seatReservedCreator) {
        this.seatReservedStorage = seatReservedCreator.createReservedSeats();
    }

    public List<SeatReserved> getReservedSeatsByShowId(int showId) {
        List<SeatReserved> results = new ArrayList<>();
        for (SeatReserved seat : seatReservedStorage) {
            if (seat.getShow().getId() == showId) {
                results.add(seat);
            }
        }
        return results;
    }

}
