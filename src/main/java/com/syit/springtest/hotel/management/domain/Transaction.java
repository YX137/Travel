package com.syit.springtest.hotel.management.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long id;
	public LocalDate date;
	
	@NotEmpty
	public String status;
	
	
	public String firstName;
	public String lastName;
	
	
}
