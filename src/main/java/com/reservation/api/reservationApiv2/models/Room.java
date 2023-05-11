package com.reservation.api.reservationApiv2.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "max_occupancy")
    private Integer maxOccupancy;


}
