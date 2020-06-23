package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Movie;
import com.codecool.moviereactorapplication.model.MovieType;
import com.codecool.moviereactorapplication.repository.MovieRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MovieCreator {
    private final MovieRepository movieRepository;

    Random random = new Random();

    public MovieCreator(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void createNumberedUniqueMoviesByIdsData(List<Integer> movieIds, Integer movieNumber) {
        List<Integer> usedMovieIds = new ArrayList<>();

        for (int i = 0; i < movieNumber; i++) {
            Integer randomMovieId = movieIds.get(random.nextInt(movieIds.size()));
            while (usedMovieIds.contains(randomMovieId))
                randomMovieId = movieIds.get(random.nextInt(movieIds.size()));
            usedMovieIds.add(randomMovieId);
            MovieType randomType = MovieType
                    .values()[random.nextInt(MovieType.values().length)];
            com.codecool.moviereactorapplication.entity.Movie movie = com.codecool.moviereactorapplication.entity.Movie
                    .builder()
                    .movieType(randomType)
                    .movieDbId(randomMovieId)
                    .build();
            movieRepository.save(movie);
        }
    }

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
