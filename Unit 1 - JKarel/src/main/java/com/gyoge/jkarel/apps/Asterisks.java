// Yogesh Thambidurai ITCS

package com.gyoge.jkarel.apps;

public class Asterisks {

    private static String repeatChar(int amount, char inputChar) {

        String returnString = "";
        for (int i = 1; i <= amount; i++) {
            returnString = returnString + inputChar;
        }

        return returnString;
    }

    public static void main(String[] args) {

        partA();
        partB();
        partC();
        partD();
        partE();

    }

    /**
     * Print the asterisks pattern in Part A
     */
    private static void partA() {
        System.out.println("Part A\n");

        for (int i = 1; i <= 10; i++) {
            System.out.println(repeatChar(i, '*'));
        }

    }

    /**
     * Print the asterisks pattern in Part B
     */
    private static void partB() {
        System.out.println("\nPart B\n");

        for (int i = 10; i >= 1; i--) {
            System.out.println(repeatChar(i, '*'));
        }

    }

    /**
     * Print the asterisks pattern in Part C
     */
    private static void partC() {
        System.out.println("\nPart C\n");

        for (int i = 1; i <= 10; i++) {
            System.out.println(repeatChar(10 - 1, ' ') + repeatChar(i, '*'));
        }

    }

    /**
     * Print the asterisks pattern in Part D
     */
    private static void partD() {
        System.out.println("\nPart D\n");

        for (int i = 10; i >= 1; i--) {
            System.out.println(repeatChar(10 - 1, ' ') + repeatChar(i, '*'));
        }

    }

    /**
     * Print the asterisks pattern in Part E
     */
    private static void partE() {
        System.out.println("\nPart E\n");

        for (int i = 1; i <= 13; i += 2) {
            System.out.println(repeatChar((13 - i) / 2, ' ') + repeatChar(i, '*'));
        }

        for (int i = 13; i >= 1; i -= 2) {
            System.out.println(repeatChar((13 - i) / 2, ' ') + repeatChar(i, '*'));
        }

    }

}