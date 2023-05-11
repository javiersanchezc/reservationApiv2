package com.reservation.api.reservationApiv2.repository;


import com.reservation.api.reservationApiv2.models.Hotel;
import com.reservation.api.reservationApiv2.models.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {


    Optional<Rate> findByHotelAndRoomTypeAndSeason(Hotel hotel, String roomType, String low);
}