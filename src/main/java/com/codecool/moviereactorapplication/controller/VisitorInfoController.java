package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.security.CustomUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class VisitorInfoController {

    private final CustomUserDetailsService customUserDetailsService;

    public VisitorInfoController(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping("/me")
    public String currentUser(){
        String username = customUserDetailsService.getCurrentUsername();
        UserDetails visitor = customUserDetailsService.loadUserByUsername(username);
        return username + "\n" + visitor.getAuthorities();
    }

}

