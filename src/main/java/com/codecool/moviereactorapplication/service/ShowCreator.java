package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Movie;
import com.codecool.moviereactorapplication.model.Room;
import com.codecool.moviereactorapplication.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ShowCreator {
    private final List<Movie> movieStorage;
    private final RoomStorage roomStorage;
    private static int showId = 1;

    @Autowired
    public ShowCreator(MovieStorage movieStorage, RoomStorage roomStorage) {
        this.movieStorage = movieStorage.getMovieStorage();
        this.roomStorage = roomStorage;
    }

    public List<Show> createShows() {
        List<Show> createdShows = new ArrayList<>();
        LocalDate startingDate = LocalDate.of(2020, 6, 20);
        LocalTime startingTime = LocalTime.of(14, 30);

        for (Movie movie : movieStorage) {
            createdShows.add(new Show(showId++, startingDate, startingTime, movie, new Room()));
        }
        return createdShows;
    }

    public List<Show> createWeeklySchedule(LocalDate fromDate) {
        List<Show> createdSchedule = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            LocalTime startingTime = LocalTime.of(12, 0);
            for (Movie movie : movieStorage) {
                createdSchedule.add(new Show(showId++, fromDate, startingTime, movie, roomStorage.getRoomById(1)));
                startingTime = startingTime.plusHours(2);
            }
            fromDate = fromDate.plusDays(1);
        }

        return createdSchedule;
    }
}
