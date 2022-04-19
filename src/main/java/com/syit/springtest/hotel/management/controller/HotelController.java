package com.syit.springtest.hotel.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.syit.springtest.hotel.management.domain.Hotel;
import com.syit.springtest.hotel.management.domain.HotelRoom;
import com.syit.springtest.hotel.management.service.HotelRoomServiceImpl;
import com.syit.springtest.hotel.management.service.HotelServiceImpl;

@RestController
public class HotelController {
	
	@Autowired
	HotelServiceImpl hotelService;
	
	@Autowired
	HotelRoomServiceImpl roomService;
	
	@PostMapping("/hotel")
	public Hotel addHotel(@RequestBody JsonNode data) {
		var h = new Hotel();
		h.name = data.get("name").asText();
		h.city = data.get("city").asText();
		h.state = data.get("state").asText();
		h.email = data.get("email").asText();
		h.mobile = data.get("mobile").asText();
		if (data.has("image")) {
			h.imageUrl = data.get("image").asText();
		}
		return this.hotelService.addHotel(h);
	}
	
	@PostMapping("/hotel/{hotelId}/room")
	public HotelRoom addNewRoom(@PathVariable int hotelId, @RequestBody JsonNode data) {
		var r = new HotelRoom();
		var h = this.hotelService.findHotelById(hotelId);
		r.hotel = h;
		r.price = 100.0;
		if (data.has("price")) {
			r.price = data.get("price").asDouble();
		}
		return this.roomService.addHotelRoom(r);
	}
	
	@GetMapping("/hotel")
	public List<Hotel> findHotelByName(@RequestParam(required = false) String query) {
		return query == null ? this.hotelService.getAllHotels() : this.hotelService.findHotelByName(query);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public Hotel findHotelById(@PathVariable int hotelId) {
		return this.hotelService.findHotelById(hotelId);
	}
	
	@GetMapping("/hotel/{hotelId}/room") // TODO Re-evaluate return type, we might also want to retur the hotel info
	public List<HotelRoom> findRoomsOfHotelByHotelId(@PathVariable int hotelId) {
		return this.findHotelById(hotelId).rooms;
	}
}
