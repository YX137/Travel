package com.syit.springtest.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syit.springtest.hotel.management.domain.HotelRoom;

public interface HotelRoomRepo extends JpaRepository<HotelRoom, Integer> {

}
