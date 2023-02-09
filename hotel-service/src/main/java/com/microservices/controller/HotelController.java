package com.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.Hotel;
import com.microservices.service.HotelService;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		Hotel addHotel = hotelService.addHotel(hotel);
		return new ResponseEntity<Hotel>(addHotel, HttpStatus.CREATED);
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable int hotelId) {
		Hotel hotel = hotelService.getHotel(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> allHotels = hotelService.getAllHotels();
		return new ResponseEntity<List<Hotel>>(allHotels, HttpStatus.OK);
	}

}
