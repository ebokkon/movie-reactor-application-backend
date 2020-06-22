package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
