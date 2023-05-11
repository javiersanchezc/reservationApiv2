package com.reservation.api.reservationApiv2.repository;



import com.reservation.api.reservationApiv2.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}