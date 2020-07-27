package com.codecool.moviereactorapplication.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController("/watchlist")
public class WatchListController {

    @GetMapping("/user")
    public void getWatchListByUser() {
        // TODO: Need to implement and its Repositories, entities. PathVariable
    }

    @PostMapping("/save")
    public void saveMovieIntoWatchList() {
        // TODO: Need to implement and its Repositories, entities. RequestBody
    }

    @DeleteMapping("/delete")
    public void deleteMovieFromWatchList() {
        // TODO: Need to implement and its Repositories, entities. RequestBody
    }
}
