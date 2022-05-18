package com.test.hotelreservationprogrmtest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.bl.hotelreservationprogram.HotelReservation;

class HotelReservationTest {
	@Test
	public void testAddHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		Assert.assertEquals(3, hotelReservation.hotelReservationList.size());
	}

	@Test
	public void givenDateRangeShouldReturnTheCheapestHotelRate() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		Assert.assertEquals(220, hotelReservation.findCheapestHotel("2020-09-10", "2020-09-11"));
	}

	@Test
	public void givenWeekDayWeekEndRatesShouldReturnThoseRates() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		Assert.assertEquals(90, hotelReservation.hotelReservationList.get("Lakewood").getWeekendRate());
		Assert.assertEquals(50, hotelReservation.hotelReservationList.get("Bridgewood").getWeekendRate());
		Assert.assertEquals(150, hotelReservation.hotelReservationList.get("Ridgewood").getWeekendRate());
	}
}
