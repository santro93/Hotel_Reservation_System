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

	@Test
	public void givenWeekendOrWeekdayDateRangeShouldReturnTheCheapestHotelRate() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		Assert.assertEquals(200, hotelReservation.findCheapestHotel("2020-09-11", "2020-09-12"));
	}

	@Test
	public void givenRatingShouldReturnTheCheapestHotelRate() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		Assert.assertEquals(4, hotelReservation.hotelReservationList.get("Bridgewood").getRating());
	}

	@Test
	public void givenDateRangeShouldReturnTheBestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		Assert.assertEquals(370, hotelReservation.findBestRatedHotel("2020-09-11", "2020-09-12"));
	}

	@Test
	public void givenDateRangeShouldReturnTheHotelSpecialRate() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		Assert.assertEquals(80, hotelReservation.hotelReservationList.get("Lakewood").getSpecialWeekdayRate());
	}

	@Test
	public void givenDateRangeShouldReturnTheCheapestBestRatedHotelforRewardCustomer() {
		HotelReservation obj = new HotelReservation();
		obj.addHotel();
		Assert.assertEquals(140, obj.findCheapestHotelForRewardCustomer("2020-09-11", "2020-09-12"));
	}
}
