//Taehyun Park taehyun.park.1@stonybrook.edu

import java.util.Scanner;
public class WhatDay {


public static String whatDay(int day, int month, int yearCentury, int century) {
    int dayNumber = (day + (13*(month+1) / 5) + yearCentury + (yearCentury / 4) + (century / 4) + 5*century) % 7;
            if (dayNumber == 0) {
                return "Saturday";
            } else if (dayNumber == 1) {
                return "Sunday";
            } else if (dayNumber == 2) {
                return "Monday";
            } else if (dayNumber == 3) {
                return "Tuesday";
            } else if (dayNumber == 4) {
                return "Wednesday";
            } else if (dayNumber == 5) {
                return "Thursday";
            } else {
                return "Friday";
            }
}

public static void main (String args[]) {

    Scanner scan = new Scanner(System.in);
    String number = scan.nextLine();
    int c = number.charAt(0) - '0';
    System.out.println(c + 1);


        Scanner yearScan = new Scanner(System.in);
        System.out.print("Enter the year (e.g. 1968): ");
        int year = yearScan.nextInt();
        int century = year / 100;
        int yearCentury = year % 100;

if (century >= 16) {

            Scanner monthScan = new Scanner(System.in);
            System.out.print("Enter month (1-12): ");
            int month = monthScan.nextInt();

            if (month == 1) {
                month = 13;
                yearCentury = yearCentury - 1;
            } else if(month == 2) {
                month =14;
                yearCentury = yearCentury - 1;
            }

            Scanner dayScan = new Scanner(System.in);
            System.out.print("Enter the day of the month (1-31): ");
            int day = dayScan.nextInt();

            System.out.println("The day of the week is " + whatDay(day, month, yearCentury, century));
        } else {
    System.out.println("Invalid year");






        }

    }
    
}