package com.codecool.moviereactorapplication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController("/watchlist")
public class WatchListController {

    @GetMapping("/user")
    public void getWatchListByUser() {
        // TODO: Need to implement and its Repositories, entities. PathVariable
    }

    @GetMapping("/save")
    public void saveMovieIntoWatchList() {
        // TODO: Need to implement and its Repositories, entities. RequestBody
    }
}
