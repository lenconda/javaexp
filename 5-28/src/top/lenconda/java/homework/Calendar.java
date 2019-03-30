package top.lenconda.java.homework;
import java.util.Scanner;

class CalendarUtils {

	public CalendarUtils(int year, int month) {
		this.year = year;
		this.month = month;
	}

	private int year;
	private int month;

	public String getMonthName (int month) {
		String[] monthNames = {
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December" };
		return monthNames[month - 1];
	}

	public boolean isLeapYear (int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return false;
	}

	public int[] getMonthTotalDays (int year) {
		int[] leapDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] nonLeapDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if(this.isLeapYear(year)) return leapDays;
		else return nonLeapDays;
	}
}

public class Calendar {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input year: ");
		int year = input.nextInt();
		System.out.print("Input the date of the first day of this year: ");
		int startDay = input.nextInt();
		printMonthTitle(1, year);
		int whatDay = printMonthBody(startDay, 1, year);
		for(int month = 2; month <= 12; month++) {
			printMonthTitle(month, year);
			whatDay = printMonthBody(whatDay, month, year);
		}
	}

	public static boolean isLeap(int year) {
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return false;
	}

	public static int[] makeSureDays(int year) {
		int[] leapDays = {
			31,29,31,30,31,30,31,31,30,31,30,31
		};
		int[] nonLeapDays = {
			31,28,31,30,31,30,31,31,30,31,30,31
		};

		if(isLeap(year))
			return leapDays;
		else
			return nonLeapDays;
	}

	private static String getMonthName(int month) {
		String[] monthNames = {
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December" };
		return monthNames[month - 1];
	}

	private static void printMonthTitle(int month, int year) {
		String monthName = getMonthName(month);
		System.out.println("         " + monthName + " " + year);
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	public static int printMonthBody(int whatDay, int month, int year) {

		int track = 0;
		for(int j = 0; j < (whatDay % 7); j++) {
			System.out.print("    ");
			track++;
		}
		int[] days = makeSureDays(year);
		for(int i = 1; i <= days[month - 1]; i++) {
			System.out.printf("%4d", i);
			track++;
			if(track % 7 == 0) {
				System.out.printf("\n");
			}
		}
		System.out.printf("\n");
		return (track % 7);
	}

}
