package com.gyoge.itcsfundamentals;

import java.util.Scanner;

/** @author Yogesh Thambidurai */
public class ConvertToDMY {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number of days: ");
        int days = scanner.nextInt();

        int[] dmy = convertToDMY(days);
        System.out.printf(
            "%d days is %d years, %d months, and %d days.%n",
            days,
            dmy[0],
            dmy[1],
            dmy[2]
        );
    }

    /**
     * Given a number of days, return an array of the number of years, months, and days.
     *
     * @param days number of days
     * @return array of years, months, and days
     */
    public static int[] convertToDMY(int days) {
        return new int[]{
            days / 365,
            days % 365 / 30,
            days % 365 % 30
        };
    }

}
