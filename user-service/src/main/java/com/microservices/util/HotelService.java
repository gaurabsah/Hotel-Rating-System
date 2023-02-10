package com.microservices.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.model.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/api/v1/hotel/{hotelId}")
	Hotel getHotel(@PathVariable("hotelId") int hotelId);

}
