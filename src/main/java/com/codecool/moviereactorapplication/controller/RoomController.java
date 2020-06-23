package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Room;
import com.codecool.moviereactorapplication.repository.RoomRepository;
import com.codecool.moviereactorapplication.service.RoomStorage;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomStorage roomStorage;
    private final RoomRepository roomRepository;

    public RoomController(RoomStorage roomStorage, RoomRepository roomRepository) {
        this.roomStorage = roomStorage;
        this.roomRepository = roomRepository;
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") Integer id) {
        return roomRepository.findById(Long.valueOf(id));
        //return roomStorage.getRoomById(id);
    }
}
