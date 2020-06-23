package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> getSeatsByRoomId(Long id);
}
