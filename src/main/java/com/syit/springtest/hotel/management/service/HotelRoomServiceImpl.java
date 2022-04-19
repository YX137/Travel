package com.syit.springtest.hotel.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syit.springtest.hotel.management.domain.HotelRoom;
import com.syit.springtest.hotel.management.repository.HotelRoomRepo;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {
	
	@Autowired
	HotelRoomRepo repo;

	@Override
	public HotelRoom findHotelRoomById(int globalRoomId) {
		return this.repo.findById(globalRoomId).get();
	}

	@Override
	public HotelRoom addHotelRoom(HotelRoom newRoomInfo) {
		return this.repo.save(newRoomInfo);
	}

}
