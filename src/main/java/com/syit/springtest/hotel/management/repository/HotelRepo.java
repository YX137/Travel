package com.syit.springtest.hotel.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syit.springtest.hotel.management.domain.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {
	
	List<Hotel> findHotelByName(String name);

}
