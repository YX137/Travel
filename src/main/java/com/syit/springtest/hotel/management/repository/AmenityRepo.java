package com.syit.springtest.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syit.springtest.hotel.management.domain.Amenity;

public interface AmenityRepo extends JpaRepository<Amenity, Integer> {
	
	public Amenity findAmenityByName(String name);
}
