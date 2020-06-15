package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.model.Room;
import com.codecool.moviereactorapplication.service.RoomStorage;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomStorage roomStorage;

    public RoomController(RoomStorage roomStorage) {
        this.roomStorage = roomStorage;
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") Integer id) {
        return roomStorage.getRoomById(id);
    }
}
