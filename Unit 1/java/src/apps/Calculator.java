// Yogesh Thambidurai ITCS

package apps;

import javax.swing.JOptionPane;

public class Calculator {

    public static void main(String[] args) {
        // Dialogue box allows user input for the values to be calculated and parses
        // them to doubles
        double value1 = Double.parseDouble(JOptionPane.showInputDialog("Please enter first value"));
        double value2 = Double.parseDouble(JOptionPane.showInputDialog("Please enter second value"));

        System.out.println("Addition: " + value1 + " + " + value2 + " = " + add(value1, value2));
        System.out.println("Subtraction: " + value1 + " - " + value2 + " = " + subtract(value1, value2));
        System.out.println("Multiplication: " + value1 + " * " + value2 + " = " + multiply(value1, value2));
        System.out.println("Division: " + value1 + " / " + value2 + " = " + divide(value1, value2));
        System.out.println("Maximum value: " + findMax(value1, value2));
        System.out.println("Minimum value: " + findMin(value1, value2));
        System.out.println("Square root of " + value1 + ":" + " = " + squareRoot(value1));
        System.out.println("Power: " + value1 + "^" + value2 + " = " + power(value1, value2));
        System.out.println(
                "Pythagorean: for c = " + value1 + " and a = " + value2 + " then b = " + pythagorean(value1, value2));

    }

    // add
    // return the sum of 2 double inputs
    public static double add(double value1, double value2) {
        return value1 + value2;
    }

    // subtract
    // return the difference of 2 double inputs
    public static double subtract(double value1, double value2) {
        return value1 - value2;
    }

    // multiply
    // return the product of 2 double inputs
    public static double multiply(double value1, double value2) {
        return value1 * value2;
    }

    // divide
    // return the quotient of 2 double inputs
    public static double divide(double value1, double value2) {
        return value1 / value2;
    }

    // findMax
    // return the maximum of 2 double inputs using Math.max
    public static double findMax(double value1, double value2) {
        return Math.max(value1, value2);
    }

    // findMin
    // return the minimum of 2 double inputs using Math.min
    public static double findMin(double value1, double value2) {
        return Math.min(value1, value2);
    }

    // squareRoot
    // return the square root of a double input using Math.sqrt
    public static double squareRoot(double value1) {
        return Math.sqrt(value1);
    }

    // power
    // raise a double input to another double input using Math.pow
    public static double power(double value1, double value2) {
        return Math.pow(value1, value2);
    }

    // pythagorean
    // given the hypotenuse and one side of a right triangle, return the missing
    // side using the pythagorean theorem
    public static double pythagorean(double value1, double value2) {
        return Math.sqrt(Math.pow(value1, 2) - Math.pow(value2, 2));
    }

}