package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.service.RoomStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show/room")
public class RoomController {

    @Autowired
    private RoomStorage roomStorage;
}
