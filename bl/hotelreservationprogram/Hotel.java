package com.bl.hotelreservationprogram;

public class Hotel {
	String hotelName;
	int weekdayRate;
	int weekendRate;
	int avgRate;
	int rating;
	int specialWeekdayRate;
	int specialWeekendRate;
	int specialAvgRate;

	public Hotel(String hotelName, int rating, int weekdayRate, int weekendRate, int specialWeekdayRate,
			int specialWeekendRate) {
		this.hotelName = hotelName;
		this.rating = rating;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.avgRate = weekdayRate + weekendRate;
		this.specialWeekdayRate = specialWeekdayRate;
		this.specialWeekendRate = specialWeekendRate;
		this.specialAvgRate = specialWeekdayRate + specialWeekendRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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

	public int getSpecialAvgRate() {
        return specialAvgRate;
    }

    public void setSpecialAvgRate(int specialAvgRate) {
        this.specialAvgRate = specialAvgRate;
    }
    
    public int getSpecialWeekdayRate() {
        return specialWeekdayRate;
    }

    public void setSpecialWeekdayRate(int specialWeekdayRate) {
        this.specialWeekdayRate = specialWeekdayRate;
    }

    public int getSpecialWeekendRate() {
        return specialWeekendRate;
    }

    public void setSpecialWeekendRate(int specialWeekendRate) {
        this.specialWeekendRate = specialWeekendRate;
    }

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", rating=" + rating + ", weekdayRate=" + weekdayRate + ", weekendRate=" + weekendRate
				+ ", avgRate=" + avgRate  + ", specialWeekdayRate=" + specialWeekdayRate
				+ ", specialWeekendRate=" + specialWeekendRate + ", specialAvgRate=" + specialAvgRate + "]\n";
	}
}
