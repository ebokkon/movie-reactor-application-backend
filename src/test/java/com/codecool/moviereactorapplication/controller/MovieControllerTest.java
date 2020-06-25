package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Movie;
import com.codecool.moviereactorapplication.model.MovieType;
import com.codecool.moviereactorapplication.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieControllerTest {
    @Autowired
    private MovieRepository movieRepository;

    MovieController movieController;

    @BeforeEach
    void initialize() {
        movieController = new MovieController(movieRepository);
    }

    @Test
    void testOneMovieIsScheduled() {
        Movie movie = Movie.builder()
                .movieDbId(1122)
                .movieType(MovieType.HU2D)
                .build();
        movieRepository.save(movie);

        assertEquals(movieRepository.findAll(), movieController.getAllScheduledMovie());
    }
}