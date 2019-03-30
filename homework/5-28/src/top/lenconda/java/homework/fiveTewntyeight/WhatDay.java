package top.lenconda.java.homework.fiveTewntyeight;
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
                "December"
        };
        return monthNames[month - 1];
    }

    public String getWeekDay (int day) {
        String[] weekDay = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        return weekDay[day - 1];
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

public class WhatDay {

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input year: ");
        int year = input.nextInt();
        System.out.println("Input the day first day of this year: ");
        int startDay = input.nextInt();
        Year currentYear = new Year(year);
        System.out.println(generateResult(currentYear.getMonthName(1), year, currentYear.getWeekDay(startDay)));
        for (int i = 2; i <= 12; i++) {
            int lastMonthTotalDays = currentYear.getMonthTotalDays()[i - 2];
            int lastDay = lastMonthTotalDays % 7;
            int thisMonthFirstDay = lastDay + startDay;
            if (thisMonthFirstDay > 7) startDay = thisMonthFirstDay - 7;
            else startDay = thisMonthFirstDay;
            String day = currentYear.getWeekDay(startDay);
            System.out.println(generateResult(currentYear.getMonthName(i), year, day));
        }
    }

    private static String generateResult (String month, int year, String day) {
        return month + " 1, " + year + " is " + day;
    }

}
