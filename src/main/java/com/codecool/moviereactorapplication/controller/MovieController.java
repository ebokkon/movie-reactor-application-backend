package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.model.Movie;
import com.codecool.moviereactorapplication.service.MovieStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieStorage movieStorage;

    @Autowired
    public MovieController(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @CrossOrigin
    @GetMapping("/scheduled-movies")
    public List<Movie> getAllScheduledMovie() {
        return movieStorage.getAllMovie();
    }
}
