package com.bl.hotelreservationprogram;

public class HotelReservationMain {
	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation System");

		HotelReservation hotelReservation = new HotelReservation();
		System.out.println("\nHotel List for Customer is :-");
		hotelReservation.addHotel();
		System.out.println("\nCheapest Best Rated Hotel for Regular Customer on given Date Range is :-");
		hotelReservation.findCheapestHotel("2020-09-11", "2020-09-12");
	}
}