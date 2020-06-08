package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomStorage {
    List<Room> roomStorage = new ArrayList<>();

    public Room getRoomById(Integer id) {
        for (Room actualRoom: roomStorage){
            if (actualRoom.getId() == id){
                return actualRoom;
            }
        }
        return null;
    }
}
