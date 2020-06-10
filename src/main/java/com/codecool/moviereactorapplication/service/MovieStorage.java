package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieStorage {

    MovieCreator movieCreator;
    List<Movie> movieStorage;

    @Autowired
    public MovieStorage(MovieCreator movieCreator) {
        List<Integer> movieIds = Arrays.asList(111, 150, 200, 500, 1500, 55, 60, 30, 90, 110);

        this.movieCreator = movieCreator;
        this.movieStorage = movieCreator.createNumberedUniqueMoviesByIds(movieIds, 5);
    }

    public List<Movie> getMovieStorage() {
        return movieStorage;
    }
}