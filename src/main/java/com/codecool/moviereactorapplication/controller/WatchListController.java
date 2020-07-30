package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Visitor;
import com.codecool.moviereactorapplication.repository.VisitorRepository;
import com.codecool.moviereactorapplication.security.CustomUserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController("/watchlist")
public class WatchListController {

    private final VisitorRepository allVisitors;

    private final CustomUserDetailsService customUserDetailsService;

    public WatchListController(VisitorRepository allVisitors, CustomUserDetailsService customUserDetailsService) {
        this.allVisitors = allVisitors;
        this.customUserDetailsService = customUserDetailsService;
    }

//    @GetMapping("/user/{id}")
//    public List<Long> getWatchListByUser(@PathVariable("user_id") Long userId) {
//        return allVisitors.getWatchListByUser(userId);
//    }
//
//    @GetMapping("/save")
//    public void saveMovieIntoWatchList(@RequestParam("movie_id") Long movieId) {
//        String username = customUserDetailsService.findLoggedInUsername();
//        if (username != null) {
//            Visitor user = allVisitors.findUserByUsername(username);
//            List<Long> watchList = allVisitors.getWatchListByUser(user.getId());
//            watchList.add(movieId);
//            user.setWatchListMovieIds(watchList);
//            allVisitors.save(user);
//        }
//    }
}
