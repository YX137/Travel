package com.syit.springtest.hotel.management.service;

import com.syit.springtest.hotel.management.domain.HotelRoom;

public interface HotelRoomService {
	
	public HotelRoom findHotelRoomById(int globalRoomId);
	
	public HotelRoom addHotelRoom(HotelRoom newRoomInfo);
}
