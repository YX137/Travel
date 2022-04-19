package com.syit.springtest.hotel.management.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syit.springtest.hotel.management.domain.Hotel;
import com.syit.springtest.hotel.management.repository.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepo repo;
	
	@Override
	public Hotel findHotelById(int id) {
		return this.repo.findById(id).get();
	}
	
	@Override
	public Hotel addHotel(Hotel h) {
		return this.repo.save(h);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return this.repo.findAll();
	}
	
	@Override
	public List<Hotel> findHotelByName(String name) {
		return this.repo.findHotelByName(name);
	}

	@Override
	public List<Hotel> findHotelByAmenity(String name) {
		return this.repo.findAll()
				.stream()
				.filter(h -> h.rooms.stream()
						.anyMatch(r -> r.amenities.stream()
								.anyMatch(a -> Objects.equals(name, a.name))))
				.collect(Collectors.toList());
	}
}
