package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Show;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowStorage {

    private List<Show> shows = new ArrayList<>();

    public List<Show> getShows() {
        return shows;
    }
}
