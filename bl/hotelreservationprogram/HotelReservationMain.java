package com.bl.hotelreservationprogram;

public class HotelReservationMain {
	public static void main(String[] args) {
		System.out.println("Welcome to the Hotel Reservation System");

		HotelReservation hotelReservation = new HotelReservation();
		System.out.println("Added special rates in Weekday & "
				+ "Weekend Rates per day Hotel List is :-");
		hotelReservation.addHotel();
	}
}