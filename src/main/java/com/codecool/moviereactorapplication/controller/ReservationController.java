package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.SeatReservedWrapper;
import com.codecool.moviereactorapplication.service.SeatReservedOrganiser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@CrossOrigin
@RestController
@RequestMapping("/reservation")
@Slf4j
public class ReservationController {

    private final SeatReservedOrganiser seatReservedOrganiser;

    public ReservationController(SeatReservedOrganiser seatReservedOrganiser) {
        this.seatReservedOrganiser = seatReservedOrganiser;
    }

    @Transactional
    @PostMapping(value = "/seats")
    public boolean saveReservedSeat(@RequestBody SeatReservedWrapper reservationInfoWrapper) throws IllegalStateException {
        return seatReservedOrganiser.saveReservedSeat(reservationInfoWrapper);
    }

    @DeleteMapping("/delete")
    public boolean deleteReservation(@RequestBody SeatReservedWrapper seats) {
        return true;
        // TODO: Need to implement
    }

}
