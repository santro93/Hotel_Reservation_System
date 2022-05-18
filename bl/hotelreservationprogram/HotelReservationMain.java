package com.bl.hotelreservationprogram;

public class HotelReservationMain {
	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation System");

		HotelReservation hotelReservation = new HotelReservation();
		System.out.println("Hotel List for Regular Customer is :-");
		hotelReservation.addHotel();
		System.out.println("Cheapest Best Rated Hotel for a given Date Range is :-");
		hotelReservation.findCheapestHotel("2020-09-11", "2020-09-12");
	}
}