package com.bl.hotelreservationprogram;

import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
	public Map<String, Hotel> hotelReservationList;

	public HotelReservation() {
		hotelReservationList = new HashMap<String, Hotel>();
	}

	public void addHotel() {
		Hotel hotel1 = new Hotel("Lakewood", 110);
		Hotel hotel2 = new Hotel("Bridgewood", 150);
		Hotel hotel3 = new Hotel("Ridgewood", 220);

		hotelReservationList.put(hotel1.getHotelName(), hotel1);
		hotelReservationList.put(hotel2.getHotelName(), hotel2);
		hotelReservationList.put(hotel3.getHotelName(), hotel3);

		System.out.println(hotelReservationList);
	}
}