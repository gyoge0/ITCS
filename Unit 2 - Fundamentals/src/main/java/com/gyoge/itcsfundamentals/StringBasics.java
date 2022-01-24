package com.gyoge.itcsfundamentals;

import java.util.Scanner;

@SuppressWarnings({"SpellCheckingInspection", "StringConcatenationInLoop"})
public class StringBasics {

    /**
     * Given a name, return a greeting.
     *
     * @param name The name (ex. Matt)
     * @return The greeting (ex. Hello Matt! Have a nice day!)
     */
    public static String greet(String name) {
        return "Hello " + name + "! Have a nice day!";
    }

    /**
     * Given a String, return the word/sentence reversed
     *
     * @param s The String to reverse (ex. Hello!)
     * @return The reversed String (ex. !olleH)
     */
    public static String reverse(String s) {
        String ret = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            ret += s.charAt(i);
        }
        return ret;
    }

    /**
     * Given a full name return it in the format Last, First
     *
     * @param fullName The full name (ex. Wayde Byard)
     * @return The formatted name (ex. Byard, Wayde)
     */
    public static String lastFirst(String fullName) {
        String[] names = fullName.split(" ");
        return names[names.length - 1] + ", " + names[0];
    }

    /**
     * Given a full name return the proper initials
     *
     * @param fullName The full name (ex. Albus Percival Wulfric Brian Dumbledore)
     * @return The initials (ex. APWBD)
     */
    public static String initials(String fullName) {
        String ret = "";
        for (String name : fullName.split(" ")) {
            ret += name.charAt(0);
        }
        return ret;
    }

    /**
     * Given a String, return the number of vowels it contains (AEIOU)
     *
     * @param s The String to check (ex. Hello)
     * @return The number of vowels (ex. 2)
     */
    public static int countVowels(String s) {
        int vowels = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            }
        }
        return vowels;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Whats your name?");
            String name = scanner.nextLine();

            System.out.println(greet(name));

            System.out.println("Enter a string to reverse:");
            System.out.println(reverse(scanner.nextLine()));

            System.out.println("Your name (properly) is: " + lastFirst(name));

            System.out.println("Your initials are: " + initials(name));

            System.out.println("Enter a string to count vowels in:");
            System.out.println(countVowels(scanner.nextLine()));

            System.out.println("Type \"quit\" to quit, or anything else to run this again.");
        } while (!scanner.nextLine().equals("quit"));
    }

}
