package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Seat;
import com.codecool.moviereactorapplication.entity.SeatReserved;
import com.codecool.moviereactorapplication.entity.SeatReservedWrapper;
import com.codecool.moviereactorapplication.entity.Show;
import com.codecool.moviereactorapplication.repository.SeatRepository;
import com.codecool.moviereactorapplication.repository.SeatReservedRepository;
import com.codecool.moviereactorapplication.repository.ShowRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final SeatReservedWrapper seatReservedWrapper;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final SeatReservedRepository seatReservedRepository;

    public ReservationController(SeatReservedRepository seatReservedRepository, SeatReservedWrapper seatReservedWrapper, ShowRepository showRepository, SeatRepository seatRepository) {
        this.seatReservedWrapper = seatReservedWrapper;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.seatReservedRepository = seatReservedRepository;
    }

    @Transactional
    @PostMapping(value = "/seats")
    @ResponseBody
    public boolean saveReservedSeat(@RequestBody SeatReservedWrapper reservationInfoWrapper)
            throws IllegalArgumentException {
            Long showId = reservationInfoWrapper.getId();
        // TODO: check if exception class is correct OR use try-catch
        Show actualShow = showRepository.getShowById(showId);
            if (actualShow == null) {
                System.out.println("Show not found.");
                return false;
            }

            List<Long> seatIds = reservationInfoWrapper.getSeats();
            for (Long actualSeatId : seatIds) {
                Seat actualSeat = seatRepository.getById(actualSeatId);
                if (actualSeat == null) {
                    System.out.println("Seat not found.");
                    return false;
                }

                SeatReserved foundSeat = seatReservedRepository.getSeatReservedBySeatAndShow(actualSeat, actualShow);
                if (foundSeat != null) {
                    System.out.println("Uuups, already taken");
                    return false;
                }
                    SeatReserved newSeatReserved = SeatReserved.builder()
                            .seat(actualSeat)
                            .show(actualShow)
                            .build();
                    seatReservedRepository.save(newSeatReserved);
            }
            return true;
    }
}
