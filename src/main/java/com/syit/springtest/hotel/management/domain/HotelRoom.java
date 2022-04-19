package com.syit.springtest.hotel.management.domain;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A {@code HotelRoom} entity describes a kind of room provided by a certain hotel.
 */
@Entity
public class HotelRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	@ManyToOne()
	@JoinColumn(name = "hotel_id", nullable = false)
	@JsonIgnore // TODO We need proper DTO but for now this works
	public Hotel hotel;
	
	public String type; // TODO Enum
	
	public String area;
	
	@PositiveOrZero
	public double price = 0;
	
	@ManyToMany
	@JoinTable(name = "room_amenities")
	//@JsonIgnore
	public Set<Amenity> amenities = Collections.emptySet();
	
	@PositiveOrZero
	public int totalRooms = 0;
	
	public int getHotelId() {
		return this.hotel.id;
	}
}
