package com.micro.microservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long userid;
	String name;
	String email;
	String password;
	String address;
}