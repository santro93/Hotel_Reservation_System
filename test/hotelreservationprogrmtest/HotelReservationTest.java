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
}
