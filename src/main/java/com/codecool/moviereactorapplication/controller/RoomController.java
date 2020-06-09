package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.model.Room;
import com.codecool.moviereactorapplication.service.RoomStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomStorage roomStorage;

    @CrossOrigin
    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") Integer id) throws Exception {
        return roomStorage.getRoomById(id);
    }
}
