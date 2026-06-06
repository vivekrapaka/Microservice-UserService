package com.micro.microservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.micro.microservice.dto.OrderDetails;


@FeignClient("order-service")
public interface OrderServiceFiegnClient {

	@PostMapping("order/create")
	public String createOrder(@RequestBody OrderDetails order);
}
