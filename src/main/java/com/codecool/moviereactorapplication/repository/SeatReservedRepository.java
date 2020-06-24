package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.SeatReserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatReservedRepository extends JpaRepository<SeatReserved, Long> {
    List<SeatReserved> getReservedSeatsByShowId(Long showId);
}
