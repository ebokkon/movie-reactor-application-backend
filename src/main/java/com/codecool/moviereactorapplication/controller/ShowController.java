package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.model.Show;
import com.codecool.moviereactorapplication.service.ShowStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ShowStorage showStorage;

    @GetMapping("/schedule")
    public List<Show> allShows() {
        return showStorage.getShows();
    }

    @GetMapping("/show/{showId}")
    public Show getShowById(@PathVariable String showId) {
        try {
            Integer id = Integer.parseInt(showId);
            return showStorage.getShowById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Show();
    }


}
