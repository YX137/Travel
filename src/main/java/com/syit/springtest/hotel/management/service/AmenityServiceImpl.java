package com.syit.springtest.hotel.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syit.springtest.hotel.management.domain.Amenity;
import com.syit.springtest.hotel.management.repository.AmenityRepo;

@Service
public class AmenityServiceImpl implements AmenityService {
	
	@Autowired
	AmenityRepo repo;

	@Override
	public Amenity getOneAmenityById(int id) {
		return this.repo.getById(id);
	}

	@Override
	public Amenity getOneAmenityByName(String name) {
		return this.repo.findAmenityByName(name);
	}

	@Override
	public List<Amenity> findAllAmenities() {
		return this.repo.findAll();
	}

}
