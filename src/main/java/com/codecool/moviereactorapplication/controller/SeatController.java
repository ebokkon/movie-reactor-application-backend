package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.model.Room;
import com.codecool.moviereactorapplication.model.Seat;
import com.codecool.moviereactorapplication.service.SeatStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatController {

    private SeatStorage seatStorage;

    @Autowired
    public SeatController(SeatStorage seatStorage) {
        this.seatStorage = seatStorage;
    }

    @GetMapping("/seat/room/{id}")
    public List<Seat> getSeatByRoomId(@PathVariable("id") int roomId) throws Exception {
        return seatStorage.getSeatsByRoomId(roomId);
    }
}
