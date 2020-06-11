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
        List<Integer> movieIds = Arrays.asList(496243, 530915, 495764, 514847, 475557, 556678, 111, 122, 155, 501907);

        this.movieCreator = movieCreator;
        this.movieStorage = movieCreator.createNumberedUniqueMoviesByIds(movieIds, 5);
    }

    public List<Movie> getMovieStorage() {
        return movieStorage;
    }

    public List<Movie> getAllMovie() {
        return this.movieStorage;
    }
}