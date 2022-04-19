package com.syit.springtest.hotel.management.domain;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "hotel")
public class Hotel {
	
	public enum Status {
		OPEN, CLOSED;
		
		@javax.persistence.Converter
		public static final class Converter implements AttributeConverter<Status, String> {

			@Override
			public String convertToDatabaseColumn(Status attribute) {
				return attribute.name();
			}

			@Override
			public Status convertToEntityAttribute(String dbData) {
				return Status.valueOf(dbData.toUpperCase(Locale.ROOT));
			}
			
		}
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	public String name;
	public String city;
	public String state;
	
	@Email
	public String email;
	public String mobile;
	
	@URL
	public String imageUrl;
	
	@PositiveOrZero
	public int star = 0;

	@Convert(converter = Status.Converter.class)
	@Enumerated(EnumType.STRING)
	public Status status = Status.OPEN;
	
	@OneToMany(mappedBy = "hotel") // mappedBy is the column name in the table of the "many" in the "one-to-many" relation.
	public List<HotelRoom> rooms = Collections.emptyList();
	
	public List<Amenity> getAmenities() {
		return this.rooms.stream().flatMap(r -> r.amenities.stream()).distinct().collect(Collectors.toList());
	}

}
