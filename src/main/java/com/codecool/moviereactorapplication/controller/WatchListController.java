package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Visitor;
import com.codecool.moviereactorapplication.repository.VisitorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController("/watchlist")
public class WatchListController {

    private final VisitorRepository visitorRepository;

    public WatchListController(VisitorRepository visitorRepository){
        this.visitorRepository=visitorRepository;
    }

    @GetMapping("/user")
    public List<Map<String,Integer>> getWatchListByUser(@RequestHeader String username) {
        List<Map<String,Integer>> returnList=new ArrayList<>();
        List<Integer> idList=visitorRepository.getByUsername(username).getWatchList();
        for(int id : idList){
            Map<String,Integer> data=new HashMap<>();
            data.put("id",id);
            returnList.add(data);
        }
        return returnList;
    }

    @PostMapping("/save/{movie_db_id}")
    public boolean saveMovieIntoWatchList(@RequestHeader String username,@PathVariable Integer movie_db_id) {
        Visitor visitor=visitorRepository.getByUsername(username);
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
    public boolean deleteMovieFromWatchList(@PathVariable Integer movie_db_id,@RequestHeader String username) {
        if(!visitorRepository.getByUsername(username).getWatchList().contains(movie_db_id)){
            return false;
        }
        Visitor visitor=visitorRepository.getByUsername(username);
        List<Integer> watchList=visitor.getWatchList();
        watchList.remove(movie_db_id);
        visitor.setWatchList(watchList);
        visitorRepository.save(visitor);
        return true;
    }
}
