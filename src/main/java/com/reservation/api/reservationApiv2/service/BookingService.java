package com.reservation.api.reservationApiv2.service;

import com.reservation.api.reservationApiv2.models.Booking;
import com.reservation.api.reservationApiv2.models.Hotel;
import com.reservation.api.reservationApiv2.models.Rate;
import com.reservation.api.reservationApiv2.models.Room;
import com.reservation.api.reservationApiv2.repository.BookingRepository;
import com.reservation.api.reservationApiv2.repository.HotelRepository;
import com.reservation.api.reservationApiv2.repository.RateRepository;
import com.reservation.api.reservationApiv2.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class BookingService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RateRepository rateRepository;

    public Booking makeReservation(Long hotelId, Long roomId, Date startDate, Date endDate, Integer numberOfPeople) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if (!optionalHotel.isPresent()) {
            throw new RuntimeException("Hotel not found with id: " + hotelId);
        }
        Hotel hotel = optionalHotel.get();

        Optional<Room> optionalRoom = roomRepository.findById(roomId);
        if (!optionalRoom.isPresent()) {
            throw new RuntimeException("Room not found with id: " + roomId);
        }
        Room room = optionalRoom.get();

        if (numberOfPeople > room.getMaxOccupancy()) {
            throw new RuntimeException("The number of people exceeds the maximum occupancy of the room.");
        }

        // Verificar disponibilidad de habitaciones
        List<Booking> bookings = bookingRepository.findByRoomAndDates(room, startDate, endDate);
        int bookedRooms = bookings.stream().mapToInt(Booking::getNumberOfPeople).sum();
        int availableRooms = room.getQuantity() - bookedRooms;
        if (numberOfPeople > availableRooms) {
            throw new RuntimeException("There are not enough available rooms for the selected dates.");
        }

        // Calcular la tarifa de la reserva
        Optional<Rate> optionalRate = rateRepository.findByHotelAndRoomTypeAndSeason(hotel, room.getRoomType(), "low");
        if (!optionalRate.isPresent()) {
            throw new RuntimeException("Rate not found.");
        }
        Rate rate = optionalRate.get();
        double pricePerNight = rate.getPrice();
        long diffInDays = TimeUnit.DAYS.convert(endDate.getTime() - startDate.getTime(), TimeUnit.MILLISECONDS);
        double totalPrice = pricePerNight * diffInDays * numberOfPeople;

        // Crear una nueva reserva y guardarla en la base de datos
        Booking booking = new Booking();
        booking.setHotel(hotel);
        booking.setRoom(room);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setNumberOfPeople(numberOfPeople);
        booking.setTotalPrice(totalPrice);
        bookingRepository.save(booking);

        return booking;
    }
}
