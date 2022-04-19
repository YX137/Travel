package com.syit.springtest.hotel.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syit.springtest.hotel.management.domain.Amenity;
import com.syit.springtest.hotel.management.service.AmenityService;

@RestController
public class AmenityController {
	
	@Autowired
	public AmenityService service;
	
	@GetMapping("/amenity")
	public List<Amenity> getAmenitiesList() {
		return this.service.findAllAmenities();
	}

}
