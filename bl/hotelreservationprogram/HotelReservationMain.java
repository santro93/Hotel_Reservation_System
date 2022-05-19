package com.bl.hotelreservationprogram;

public class HotelReservationMain {
	public static void main(String[] args) throws IndexOutOfBoundsException {
		System.out.println("Welcome to the Hotel Reservation System");

		HotelReservation hotelReservation = new HotelReservation();
		System.out.println("\nHotel List for Customer is :-");
		hotelReservation.addHotel();
		System.out.println("\nCheapest Best Rated Hotel for a given Date Range "
				+ "Reward Customer is :-");
		hotelReservation.findCheapestHotelForRewardCustomer("2020-09-11", "2020-09-12");
	}
}