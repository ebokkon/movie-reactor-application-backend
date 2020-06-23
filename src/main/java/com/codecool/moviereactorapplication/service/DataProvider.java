package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.entity.Room;
import com.codecool.moviereactorapplication.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataProvider implements CommandLineRunner {

    private final RoomCreator roomCreator;
    private final MovieCreator movieCreator;
    private final SeatCreator seatCreator;

    private final RoomRepository roomRepository;

    List<Integer> movieIds = Arrays.asList(496243, 530915, 495764, 514847, 475557, 556678, 111, 122, 155, 501907);

    public DataProvider(RoomCreator roomCreator, MovieCreator movieCreator, SeatCreator seatCreator, RoomRepository roomRepository) {
        this.roomCreator = roomCreator;
        this.movieCreator = movieCreator;
        this.seatCreator = seatCreator;
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        roomCreator.createNumberedRooms(1);

        movieCreator.createNumberedUniqueMoviesByIdsData(movieIds, 5);
        List<Room> rooms = roomRepository.findAll();
        for (Room room : rooms) {
            System.out.println("For loop: " + room.getName());
            seatCreator.createSeatsForRoomData(room);
        }
    }
}
