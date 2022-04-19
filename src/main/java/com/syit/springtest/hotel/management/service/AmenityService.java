package com.syit.springtest.hotel.management.service;

import java.util.List;

import com.syit.springtest.hotel.management.domain.Amenity;

public interface AmenityService {
	
	public Amenity getOneAmenityById(int id);
	
	public Amenity getOneAmenityByName(String name);
	
	public List<Amenity> findAllAmenities();

}
