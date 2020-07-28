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
    public List<Integer> getWatchListByUser() {
        return visitorRepository.getByUsername("user").getWatchList();
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

    @DeleteMapping("/delete/{movie_db_id}")
    public boolean deleteMovieFromWatchList(@PathVariable Integer movie_db_id) {
        if(!visitorRepository.getByUsername("user").getWatchList().contains(movie_db_id)){
            return false;
        }
        Visitor visitor=visitorRepository.getByUsername("user");
        List<Integer> watchList=visitor.getWatchList();
        watchList.remove(movie_db_id);
        visitor.setWatchList(watchList);
        visitorRepository.save(visitor);
        return true;
    }
}
