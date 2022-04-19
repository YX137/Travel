package com.syit.springtest.hotel.management.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long id;
	@NotEmpty
	@Email
	public String email;
	
	public String mobile;
	
	@NotEmpty
	public String password;
	
	@Positive
	public double credit; // walletAmount

}
