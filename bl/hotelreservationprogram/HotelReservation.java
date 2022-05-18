package com.bl.hotelreservationprogram;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotelReservation {
	public Map<String, Hotel> hotelReservationList;

	public HotelReservation() {
		hotelReservationList = new HashMap<String, Hotel>();
	}

	public void addHotel() {
		Hotel hotel1 = new Hotel("Lakewood", 110, 90);
		Hotel hotel2 = new Hotel("Bridgewood", 150, 50);
		Hotel hotel3 = new Hotel("Ridgewood", 220, 150);

		hotelReservationList.put(hotel1.getHotelName(), hotel1);
		hotelReservationList.put(hotel2.getHotelName(), hotel2);
		hotelReservationList.put(hotel3.getHotelName(), hotel3);

		System.out.println(hotelReservationList);
	}

	public void enterDates() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 2 dates in yyyy-mm-dd format: ");
		String date1 = sc.nextLine();
		String date2 = sc.nextLine();
		findCheapestHotel(date1, date2);
	}

	public int findCheapestHotel(String d1, String d2) {
		int weekEnds = 0;
		DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
		DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
		if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
			weekEnds++;
		}
		if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
			weekEnds++;
		}
		if (weekEnds == 0) {
			List<Hotel> hotelObjList = hotelReservationList.values().stream()
					.sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
			System.out.println(hotelObjList.get(0).getHotelName() + ", Total Rates = $"
					+ hotelObjList.get(0).getWeekdayRate() * 2);
			return hotelObjList.get(0).getWeekdayRate() * 2;
		} else if (weekEnds == 2) {
			List<Hotel> hotelObjList = hotelReservationList.values().stream()
					.sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());
			System.out.println(hotelObjList.get(0).getHotelName() + ", Total Rates = $"
					+ hotelObjList.get(0).getWeekendRate() * 2);
			return hotelObjList.get(0).getWeekendRate() * 2;
		} else {
			List<Hotel> hotelObjList = hotelReservationList.values().stream()
					.sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).collect(Collectors.toList());
			if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate()) {
				System.out.println(hotelObjList.get(0).getHotelName() + " and "
						+ hotelObjList.get(1).getHotelName() + ", Total Rates = $"
						+ (hotelObjList.get(0).getAvgRate()));
				return hotelObjList.get(0).getAvgRate();
			} else {
				System.out.println(hotelObjList.get(0).getHotelName() + ", Total Rates = $"
						+ (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
				return hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate();
			}
		}
	}
}