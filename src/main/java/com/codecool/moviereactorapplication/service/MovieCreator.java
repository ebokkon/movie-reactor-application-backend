package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Movie;
import com.codecool.moviereactorapplication.model.MovieType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MovieCreator {
    public List<Movie> createMoviesByIds(List<Integer> movieIds) {

        List<Movie> movies = new ArrayList<>();
        Random random = new Random();

        for (Integer movieId : movieIds) {
            MovieType randomType = MovieType
                    .values()[random.nextInt(MovieType.values().length)];
            movies.add(new Movie(movieId, randomType));
        }

        return movies;
    }
}
