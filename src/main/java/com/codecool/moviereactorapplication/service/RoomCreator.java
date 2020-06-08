package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RoomCreator {
    private static List<String> roomNames = Arrays.asList("Patkós Irma", "Huszárik Zoltán", "Uránia");
    Random random = new Random();


    public List<Room> createRooms(int numberOfRooms) {

        List<Room> rooms = new ArrayList<>();
        for (int roomId = 1; roomId < numberOfRooms+1; roomId++) {
            String name = roomNames.get(random.nextInt(roomNames.size()));
            Room newRoom = new Room(roomId, name, 2, 3);
            rooms.add(newRoom);

        }
        return rooms;
    }

}
