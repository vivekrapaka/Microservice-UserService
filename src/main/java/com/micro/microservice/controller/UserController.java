package com.micro.microservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.microservice.dto.UserLoginDetails;
import com.micro.microservice.dto.UserRegisterDetails;
import com.micro.microservice.entity.UserDetails;
import com.micro.microservice.service.UserService;

@RestController("/user")
public class UserController {
	
	@Autowired
	UserService userservice;

	@PostMapping("/register")
	public String register(@RequestBody UserRegisterDetails user) {
		
		String register = userservice.register(user);
		return register;
	}
	
	@PostMapping("/login")
	public Optional<UserDetails> login(@RequestBody UserLoginDetails user) {
		
		Optional<UserDetails> login = userservice.login(user);
		return login;
	}
	
}
