package com.micro.microservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.micro.microservice.dto.PaymentLoginDetailsDto;


@FeignClient("payment-service")
public interface PaymentServiceFeignClient {

	@PostMapping("/payment/netbanking/login")
	public String netBankingLogin(@RequestBody PaymentLoginDetailsDto dto);
}
