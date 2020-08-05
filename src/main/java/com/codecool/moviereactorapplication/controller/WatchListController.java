package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Visitor;
import com.codecool.moviereactorapplication.repository.VisitorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codecool.moviereactorapplication.security.CustomUserDetailsService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/watchlist")
public class WatchListController {

    private final VisitorRepository visitorRepository;
    private final CustomUserDetailsService customUserDetailsService;

    public WatchListController(VisitorRepository visitorRepository, CustomUserDetailsService customUserDetailsService) {
        this.visitorRepository = visitorRepository;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping
    public List<Map<String, Integer>> getWatchListByUser() {
        String username = customUserDetailsService.findLoggedInUsername();
        List<Map<String, Integer>> returnList = new ArrayList<>();
        if (username == null) {
            return null;
        } else {
            List<Integer> idList = visitorRepository.getByUsername(username).getWatchList();
            for (int id : idList) {
                Map<String, Integer> data = new HashMap<>();
                data.put("id", id);
                returnList.add(data);
            }
        }
        return returnList;
    }

    @PostMapping("/save/{movie_db_id}")
    public boolean saveMovieIntoWatchList(@PathVariable Integer movie_db_id) {
        String username = customUserDetailsService.findLoggedInUsername();
        Visitor visitor;
        if (username != null) {
            visitor = visitorRepository.getByUsername(username);
        } else {
            return false;
        }
        List<Integer> watchList = visitor.getWatchList();
        if (watchList.contains(movie_db_id)) {
            return false;
        }
        watchList.add(movie_db_id);
        visitor.setWatchList(watchList);
        visitorRepository.save(visitor);
        return true;
    }

    @DeleteMapping("/delete/{movie_db_id}")
    public boolean deleteMovieFromWatchList(@PathVariable Integer movie_db_id) {
        String username = customUserDetailsService.findLoggedInUsername();
        if (!visitorRepository.getByUsername(username).getWatchList().contains(movie_db_id)) {
            return false;
        }
        Visitor visitor = visitorRepository.getByUsername(username);
        List<Integer> watchList = visitor.getWatchList();
        watchList.remove(movie_db_id);
        visitor.setWatchList(watchList);
        visitorRepository.save(visitor);
        return true;
    }

}
