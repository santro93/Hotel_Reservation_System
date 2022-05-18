package com.bl.hotelreservationprogram;

public class Hotel {
	String hotelName;
	int weekdayRate;
	int weekendRate;
	int avgRate;

	public Hotel(String hotelName, int weekdayRate, int weekendRate) {
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.avgRate = weekdayRate + weekendRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekdayRate() {
		return weekdayRate;
	}

	public void setWeekendRate(int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekdayRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}

	public int getAvgRate() {
		return avgRate;
	}

	public void setAvgRate(int avgRate) {
		this.avgRate = avgRate;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekdayRate=" + weekdayRate + ", weekendRate=" + weekendRate
				+ "]\n";
	}
}
