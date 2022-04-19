package com.syit.springtest.hotel.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.syit.springtest.hotel.management.domain.HotelRoom;
import com.syit.springtest.hotel.management.service.HotelRoomService;

@RestController
public class RoomController {
	
	@Autowired
	HotelRoomService service;
	
	@GetMapping("/room/{roomId}")
	public HotelRoom getRoomById(@PathVariable int roomId) {
		return this.service.findHotelRoomById(roomId);
	}
}
