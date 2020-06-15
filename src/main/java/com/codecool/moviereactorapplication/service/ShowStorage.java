package com.codecool.moviereactorapplication.service;

import com.codecool.moviereactorapplication.model.Show;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShowStorage {
    private final List<Show> showStorage;

    public ShowStorage(ShowCreator showCreator) {
        this.showStorage = showCreator.createWeeklySchedule(LocalDate.of(2020, 6, 11));
    }

    public List<Show> getShows() {
        return showStorage;
    }

    public Show getShowById(Integer showId) throws Exception {
        return this.showStorage.stream()
                .filter(show -> show.getId().equals(showId))
                .findFirst()
                .orElseThrow(() -> new Exception("The searched show not found with id: " + showId));
    }
}