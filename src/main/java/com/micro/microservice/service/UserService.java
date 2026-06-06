package com.micro.microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.microservice.dto.OrderDetails;
import com.micro.microservice.dto.PaymentLoginDetailsDto;
import com.micro.microservice.dto.UserLoginDetails;
import com.micro.microservice.dto.UserRegisterDetails;
import com.micro.microservice.entity.UserDetails;
import com.micro.microservice.feignclient.OrderServiceFiegnClient;
import com.micro.microservice.feignclient.PaymentServiceFeignClient;
import com.micro.microservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OrderServiceFiegnClient orderFeignClient;
	
	@Autowired
	PaymentServiceFeignClient paymentFeignClient;
	
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

	public String createOrder() {
		OrderDetails a = OrderDetails.builder().name("vivek")
				.email("vivekkumar.rapaka@gmail.com")
				.orderId("23456789")
				.contact("7993080796")
				.amount(100.00)
				.build();
		
		String order = orderFeignClient.createOrder(a);
		return order;
	}

	public String payment(PaymentLoginDetailsDto dto) {
		
		String netBankingLogin = paymentFeignClient.netBankingLogin(dto);
		return netBankingLogin;
	}

}
