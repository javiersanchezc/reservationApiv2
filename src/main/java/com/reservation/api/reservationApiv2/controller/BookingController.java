package com.reservation.api.reservationApiv2.controller;


import com.reservation.api.reservationApiv2.models.Booking;
import com.reservation.api.reservationApiv2.repository.BookingRepository;
import com.reservation.api.reservationApiv2.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings/")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    private BookingRepository bookingRepository;

    @GetMapping("listar")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return ResponseEntity.ok(bookings);
    }
/*
    @PostMapping("crear")
    public ResponseEntity<Booking> makeReservation(@RequestBody ReservationRequest reservationRequest) {
        Booking booking = bookingService.makeReservation(
                reservationRequest.getHotelId(),
                reservationRequest.getRoomId(),
                reservationRequest.getStartDate(),
                reservationRequest.getEndDate(),
                reservationRequest.getNumberOfPeople()
        );
        return ResponseEntity.ok(booking);
    }*/

}
