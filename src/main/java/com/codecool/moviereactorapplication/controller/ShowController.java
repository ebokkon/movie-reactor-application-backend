package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Show;
import com.codecool.moviereactorapplication.repository.ShowRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ShowController {
    private final ShowRepository showRepository;

    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @GetMapping("/schedule")
    public List<com.codecool.moviereactorapplication.entity.Show> allShows() {
        return showRepository.findAll();
    }

    @GetMapping("/show/{showId}")
    public Show getShowById(@PathVariable("showId") Long showId) {
        return showRepository.getShowById(showId);
//        return showRepository.getShowAndJoinWithInfo(showId);
    }
}