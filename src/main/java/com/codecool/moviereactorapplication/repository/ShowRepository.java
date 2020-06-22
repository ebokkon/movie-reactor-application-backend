package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
