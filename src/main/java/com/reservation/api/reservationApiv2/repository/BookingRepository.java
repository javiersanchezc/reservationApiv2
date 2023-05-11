package com.reservation.api.reservationApiv2.repository;



import com.reservation.api.reservationApiv2.models.Booking;
import com.reservation.api.reservationApiv2.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.room = :room AND ((b.startDate >= :startDate AND b.startDate < :endDate) OR (b.endDate > :startDate AND b.endDate <= :endDate))")
    List<Booking> findByRoomAndDates(Room room, Date startDate, Date endDate);


}
