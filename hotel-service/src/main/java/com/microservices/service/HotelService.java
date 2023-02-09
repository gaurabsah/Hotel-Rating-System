package com.microservices.service;

import java.util.List;

import com.microservices.model.Hotel;

public interface HotelService {

	Hotel addHotel(Hotel hotel);

	List<Hotel> getAllHotels();

	Hotel getHotel(int hotelId);

}
