package com.syit.springtest.hotel.management.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Amenity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	@NotNull
	public String name;
	
	public String description = "";
	
	@ManyToMany(mappedBy = "amenities")
	public List<HotelRoom> hotelRooms = Collections.emptyList();

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amenity other = (Amenity) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Amenity [id=" + id + ", name=" + name + ", description=" + description + "]";
	} 
	
}
