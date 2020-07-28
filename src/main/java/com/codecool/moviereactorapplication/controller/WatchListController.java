package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Visitor;
import com.codecool.moviereactorapplication.repository.VisitorRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@CrossOrigin
@RestController("/watchlist")
public class WatchListController {

    private final VisitorRepository visitorRepository;

    public WatchListController(VisitorRepository visitorRepository){
        this.visitorRepository=visitorRepository;
    }

    @GetMapping("/user")
    public void getWatchListByUser() {
        // TODO: Need to implement and its Repositories, entities. PathVariable
    }

    @PostMapping("/save/{movie_db_id}")
    public boolean saveMovieIntoWatchList(@PathVariable Integer movie_db_id) {
        Visitor visitor=visitorRepository.getByUsername("user");
        List<Integer> watchList=visitor.getWatchList();
        if(watchList.contains(movie_db_id)){
            return false;
        }
        watchList.add(movie_db_id);
        visitor.setWatchList(watchList);
        visitorRepository.save(visitor);
        return true;
    }

    @DeleteMapping("/delete")
    public void deleteMovieFromWatchList() {
        // TODO: Need to implement and its Repositories, entities. RequestBody
    }
}
