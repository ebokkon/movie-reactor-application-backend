package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Movie;
import com.codecool.moviereactorapplication.model.Room;
import com.codecool.moviereactorapplication.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ShowCreator {
    private final List<Movie> movieStorage;
    private static int showId = 1;
    private RoomStorage roomStorage;

    @Autowired
    public ShowCreator(MovieStorage movieStorage, RoomStorage roomStorage) {
        this.movieStorage = movieStorage.getMovieStorage();
        this. roomStorage = roomStorage;
    }

    public List<Show> createShows() {
        List<Show> createdShows = new ArrayList<>();
        LocalDate startingDate = LocalDate.of(2020, 6, 20);
        LocalTime startingTime = LocalTime.of(14, 30);

        // New Room should comes from Room Storage.
        for (Movie movie : movieStorage) {
            createdShows.add(new Show(showId++, startingDate, startingTime, movie, new Room()));
        }
        return createdShows;
    }

    public List<Show> createWeeklySchedule(LocalDate fromDate, Integer moviesPerDay) {
        List<Show> createdSchedule = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            LocalTime startingTime = LocalTime.of(12, 0);
            for (int j = 0; j < moviesPerDay; j++) {
                Movie randomMovie = movieStorage.get(random.nextInt(movieStorage.size()));
                createdSchedule.add(new Show(showId++, fromDate, startingTime, randomMovie, roomStorage.getRoomById(1)));
                startingTime = startingTime.plusHours(2);
            }
            fromDate = fromDate.plusDays(1);
        }

        return createdSchedule;
    }
}
