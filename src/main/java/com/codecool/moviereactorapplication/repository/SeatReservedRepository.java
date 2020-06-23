package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.SeatReserved;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SeatReservedRepository extends JpaRepository<SeatReserved, Long> {
    List<SeatReserved> getReservedSeatsByShowId(Long showId);
}
