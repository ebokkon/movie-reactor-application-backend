package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.model.Seat;
import com.codecool.moviereactorapplication.model.SeatReserved;
import com.codecool.moviereactorapplication.service.SeatReservedStorage;
import com.codecool.moviereactorapplication.service.SeatStorage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class SeatController {

    private final SeatStorage seatStorage;
    private final SeatReservedStorage seatReservedStorage;

    public SeatController(SeatStorage seatStorage, SeatReservedStorage seatReservedStorage) {
        this.seatStorage = seatStorage;
        this.seatReservedStorage = seatReservedStorage;
    }

    @GetMapping("/seat/room/{id}")
    public List<Seat> getSeatByRoomId(@PathVariable("id") int roomId) {
        return seatStorage.getSeatsByRoomId(roomId);
    }

    @GetMapping("/reserved-seats/show/{id}")
    public List<SeatReserved> getReservedSeatsByShowId(@PathVariable("id") int showId)  {
        return seatReservedStorage.getReservedSeatsByShowId(showId);
    }
}
