package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.service.ShowStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    @Autowired
    private ShowStorage showStorage;
}
