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
    private static int showId = 1;

    @Autowired
    public ShowCreator(MovieStorage movieStorage) {
        this.movieStorage = movieStorage.getMovieStorage();
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
}
