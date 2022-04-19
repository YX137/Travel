package com.syit.springtest.hotel.management.service;

import java.util.List;

import com.syit.springtest.hotel.management.domain.Hotel;

public interface HotelService {
	
	Hotel findHotelById(int id);
	
	Hotel addHotel(Hotel h);
	
	List<Hotel> getAllHotels();
	
	List<Hotel> findHotelByName(String name);
	
	List<Hotel> findHotelByAmenity(String name);
}
