package top.lenconda.java.homework;
import java.util.Scanner;

class Year {

    public Year (int year) {
        this.year = year;
    }

    private int year;

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

    public boolean isLeapYear () {
        if ((this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0))
            return true;
        else
            return false;
    }

    public int[] getMonthTotalDays () {
        int[] leapDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] nonLeapDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (this.isLeapYear()) return leapDays;
        else return nonLeapDays;
    }
}

public class Calendar {

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input year: ");
        int year = input.nextInt();
        System.out.print("Input the date of the first day of this year: ");
        int startDay = input.nextInt();
        Year currentYear = new Year(year);
        String monthName = currentYear.getMonthName(1);
        printMonthTitle(monthName, year);
        int whatDay = printMonthBody(startDay, 1, currentYear);
        for (int month = 2; month <= 12; month++) {
            String currentMonth = currentYear.getMonthName(month);
            printMonthTitle(currentMonth, year);
            whatDay = printMonthBody(whatDay, month, currentYear);
        }
    }

    private static void printMonthTitle(String monthName, int year) {
        System.out.println("         " + monthName + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    public static int printMonthBody(int whatDay, int month, Year year) {
        int date = 0;
        for (int j = 0; j < (whatDay % 7); j++) {
            System.out.print("    ");
            date++;
        }
        int[] days = year.getMonthTotalDays();
        for (int i = 1; i <= days[month - 1]; i++) {
            System.out.printf("%4d", i);
            date++;
            if (date % 7 == 0)
                System.out.printf("\n");
        }
        System.out.printf("\n");
        return date % 7;
    }

}
