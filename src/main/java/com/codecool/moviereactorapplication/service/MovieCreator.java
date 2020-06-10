package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Movie;
import com.codecool.moviereactorapplication.model.MovieType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MovieCreator {
    Random random = new Random();

    public List<Movie> createNumberedUniqueMoviesByIds(List<Integer> movieIds, Integer movieNumber) {
        List<Movie> movies = new ArrayList<>();
        List<Integer> usedMovieIds = new ArrayList<>();

        for (int i = 0; i < movieNumber; i++) {
            Integer randomMovieId = movieIds.get(random.nextInt(movieIds.size()));
            while (usedMovieIds.contains(randomMovieId))
                randomMovieId = movieIds.get(random.nextInt(movieIds.size()));
            usedMovieIds.add(randomMovieId);
            MovieType randomType = MovieType
                    .values()[random.nextInt(MovieType.values().length)];
            movies.add(new Movie(randomMovieId, randomType));
        }

        return movies;
    }

    public List<Movie> createMoviesByIds(List<Integer> movieIds) {
        List<Movie> movies = new ArrayList<>();

        for (Integer movieId : movieIds) {
            MovieType randomType = MovieType
                    .values()[random.nextInt(MovieType.values().length)];
            movies.add(new Movie(movieId, randomType));
        }

        return movies;
    }
}
