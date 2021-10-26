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

    private static double add(double input1, double input2) {
        return input1 + input2;
    }

    // Find the difference of input1 and input2
    private static double subtract(double input1, double input2) {
        return input1 - input2;
    }

    private static double multiply(double i1, double i2) {
        return i1 * i2;
    }

    private static double divide(double i1, double i2) {
        return i1 / i2;
    }

    private static double findMax(double i1, double i2) {
        return Math.max(i1, i2);
    }

    private static double findMin(double i1, double i2) {
        return Math.min(i1, i2);
    }

    private static double squareRoot(double i1) {
        return Math.sqrt(i1);
    }

    private static double power(double i1, double i2) {
        return Math.pow(i1, i2);
    }

    private static double pythagorean(double i1, double i2) {
        return Math.sqrt(Math.pow(i1, 2) + Math.pow(i2, 2));
    }

}
