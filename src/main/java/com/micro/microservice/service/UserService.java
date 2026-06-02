package com.micro.microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.microservice.dto.UserLoginDetails;
import com.micro.microservice.dto.UserRegisterDetails;
import com.micro.microservice.entity.UserDetails;
import com.micro.microservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public String register(UserRegisterDetails user) {
		try {
			UserDetails userDetails = new UserDetails();
			userDetails.setName(user.getName());
			userDetails.setEmail(user.getEmail());
			userDetails.setPassword(user.getPassword());
			userDetails.setAddress(user.getAddress());
			userRepo.save(userDetails);
			return "User Successully register";
		} catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}

	public Optional<UserDetails> login(UserLoginDetails user) {
		
		Optional<UserDetails> byEmailANDPassword = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return byEmailANDPassword;
	}

}
