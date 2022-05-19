package com.bl.hotelreservationprogram;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HotelReservation {
	public Map<String, Hotel> hotelReservationList;

	public HotelReservation() {
		hotelReservationList = new HashMap<String, Hotel>();
	}

	public void addHotel() {
		Hotel hotel1 = new Hotel("Lakewood", 3, 110, 90, 80, 80);
		Hotel hotel2 = new Hotel("Bridgewood", 4, 150, 50, 110, 50);
		Hotel hotel3 = new Hotel("Ridgewood", 5, 220, 150, 100, 40);

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
		findCheapestHotelForRewardCustomer(date1, date2);
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
			System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : "
					+ hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
			return hotelObjList.get(0).getWeekdayRate() * 2;
		}
		if (weekEnds == 2) {
			List<Hotel> hotelObjList = hotelReservationList.values().stream()
					.sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());
			System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : "
					+ hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekendRate() * 2);
			return hotelObjList.get(0).getWeekendRate() * 2;
		} else {
			List<Hotel> hotelObjList = hotelReservationList.values().stream()
					.sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).collect(Collectors.toList());
			if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate()
					&& hotelObjList.get(0).getRating() < hotelObjList.get(1).getRating()) {
				System.out.println("The cheapest hotel is " + hotelObjList.get(1).getHotelName() + ", Rating "
						+ hotelObjList.get(1).getRating() + ", Total Rates = $"
						+ (hotelObjList.get(1).getWeekdayRate() + hotelObjList.get(1).getWeekendRate()));
				return hotelObjList.get(1).getAvgRate();
			}
			if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate()
					&& hotelObjList.get(0).getRating() > hotelObjList.get(1).getRating()) {
				System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating "
						+ hotelObjList.get(0).getRating() + ", Total Rates = $"
						+ (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
				return hotelObjList.get(0).getAvgRate();
			} else {
				System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating "
						+ hotelObjList.get(0).getRating() + ", Total Rates = $"
						+ (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
				return hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate();
			}
		}
	}

	public int findBestRatedHotel(String d1, String d2) {
		int weekEnds = 0;
		DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
		DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
		if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
			weekEnds++;
		}
		if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
			weekEnds++;
		}
		List<Hotel> hotelObjList = hotelReservationList.values().stream()
				.sorted(Comparator.comparing(Hotel -> Hotel.rating)).collect(Collectors.toList());
		if (weekEnds == 0) {
			System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: "
					+ hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getWeekdayRate() * 2);
			return hotelObjList.get(2).getWeekdayRate() * 2;
		}
		if (weekEnds == 2) {
			System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: "
					+ hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getWeekendRate() * 2);
			return hotelObjList.get(2).getWeekendRate() * 2;
		} else {
			System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: "
					+ hotelObjList.get(2).getRating() + ", Total Rates = $"
					+ (hotelObjList.get(2).getWeekdayRate() + hotelObjList.get(2).getWeekendRate()));
			return (hotelObjList.get(2).getWeekdayRate() + hotelObjList.get(2).getWeekendRate());
		}
	}

	public int findCheapestHotelForRewardCustomer(String d1, String d2) {
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
					.sorted(Comparator.comparing(Hotel -> Hotel.specialWeekdayRate)).collect(Collectors.toList());
			System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : "
					+ hotelObjList.get(0).getRating() + ", Total Rates = $"
					+ hotelObjList.get(0).getSpecialWeekdayRate() * 2);
			return hotelObjList.get(0).getSpecialWeekdayRate() * 2;
		}
		if (weekEnds == 2) {
			List<Hotel> hotelObjList = hotelReservationList.values().stream()
					.sorted(Comparator.comparing(Hotel -> Hotel.specialWeekendRate)).collect(Collectors.toList());
			System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : "
					+ hotelObjList.get(0).getRating() + ", Total Rates = $"
					+ hotelObjList.get(0).getSpecialWeekendRate() * 2);
			return hotelObjList.get(0).getSpecialWeekendRate() * 2;
		} else {
			List<Hotel> hotelObjList = hotelReservationList.values().stream()
					.sorted(Comparator.comparing(Hotel -> Hotel.specialAvgRate)).collect(Collectors.toList());
			if (hotelObjList.get(0).getSpecialAvgRate() == hotelObjList.get(1).getSpecialAvgRate()
					&& hotelObjList.get(0).getRating() < hotelObjList.get(1).getRating()) {
				System.out.println("The cheapest hotel is " + hotelObjList.get(1).getHotelName() + ", Rating "
						+ hotelObjList.get(1).getRating() + ", Total Rates = $"
						+ (hotelObjList.get(1).getSpecialWeekdayRate() + hotelObjList.get(1).getSpecialWeekendRate()));
				return hotelObjList.get(1).getSpecialAvgRate();
			}
			if (hotelObjList.get(0).getSpecialAvgRate() == hotelObjList.get(1).getSpecialAvgRate()
					&& hotelObjList.get(0).getRating() > hotelObjList.get(1).getRating()) {
				System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating "
						+ hotelObjList.get(0).getRating() + ", Total Rates = $"
						+ (hotelObjList.get(0).getSpecialWeekdayRate() + hotelObjList.get(0).getSpecialWeekendRate()));
				return hotelObjList.get(0).getSpecialAvgRate();
			} else {
				System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating "
						+ hotelObjList.get(0).getRating() + ", Total Rates = $"
						+ (hotelObjList.get(0).getSpecialWeekdayRate() + hotelObjList.get(0).getSpecialWeekendRate()));
				return hotelObjList.get(0).getSpecialWeekdayRate() + hotelObjList.get(0).getSpecialWeekendRate();
			}
		}
	}
	
	public boolean isDateValid(String d1, String d2) {
        String regex = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(d1);
        Matcher matcher2 = pattern.matcher(d2);
        return matcher1.matches() && matcher2.matches();
    }
}