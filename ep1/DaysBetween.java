package soapopera.ep1;

import java.util.Scanner;

class DaysBetween {

    public static void main(String[] args) {
        
        Scanner myScanner = new Scanner(System.in);

        System.out.print("Enter first date: ");
        int firstDate = myScanner.nextInt();
        System.out.print("Enter second date: ");
        int secondDate = myScanner.nextInt();

        myScanner.close();

        int daysInBetween = daysSinceStart(secondDate) - daysSinceStart(firstDate);

        System.out.println("Days in between: " + daysInBetween);   
    }

    private static int daysSinceStart(int date) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int result = 0;
        int year = getYear(date);
        int month = getMonth(date);
        int day = getDay(date);

        boolean extraDayInFeb = isLeapYear(year);

        if (extraDayInFeb && month > 2) {
            result++;
        }

        while (year > 0) {
            if (isLeapYear(year - 1)) {
                result += 366;
            }
            else {
                result += 365;
            }
            year--;
        }

        while (month > 1) {
            result += daysInMonth[month - 2];
            month--;
        }

        while (day > 0) {
            result ++;
            day--;
        }

        return result;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        else if (year % 100 != 0) {
            return true;
        }
        else if (year % 400 != 0) {
            return false;
        }
        else {
            return true;
        }
    }

    private static int getYear(int date) {
        return date % 10000;
    }

    private static int getMonth(int date) {
        date /= 10000;
        return date % 100;
    }

    private static int getDay(int date) {
        date /= 1000000;
        return date % 100;
    }
}