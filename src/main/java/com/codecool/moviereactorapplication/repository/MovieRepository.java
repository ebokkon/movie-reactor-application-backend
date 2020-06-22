package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
