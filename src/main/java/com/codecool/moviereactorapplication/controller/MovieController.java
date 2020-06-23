package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Movie;
import com.codecool.moviereactorapplication.repository.MovieRepository;
import com.codecool.moviereactorapplication.service.MovieStorage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class MovieController {

    private final MovieStorage movieStorage;
    private final MovieRepository movieRepository;

    public MovieController(MovieStorage movieStorage, MovieRepository movieRepository) {
        this.movieStorage = movieStorage;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/scheduled-movies")
    public List<Movie> getAllScheduledMovie() {
        return movieRepository.findAll();
        //return movieStorage.getAllMovie();
    }
}