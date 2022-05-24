// Yogesh Thambidurai ITCS

package com.gyoge.itcs.misc;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class AngryRobotsGraphing {

    // Time increment
    @SuppressWarnings("SpellCheckingInspection")
    private static final double INCT = 0.1;
    private static double vi;
    private static double vix;
    private static double viy;
    private static int optimalAng;
    private static double ay;
    private static double angle;

    public static void main(String[] args) throws IOException {

        // User input to define initial velocity and launch angle
        // the parseDouble method converts the string input to a double
        vi = Double.parseDouble(
            JOptionPane.showInputDialog("Please enter an initial velocity in m/s"));
        angle =
            Double.parseDouble(
                JOptionPane.showInputDialog("Please enter an initial angle in degrees"));

        String[] planets = {
            "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
        };

        switch ((String)
            JOptionPane.showInputDialog(
                null,
                "Choose a planet.",
                "Planets",
                JOptionPane.PLAIN_MESSAGE,
                null,
                planets,
                planets[0])) {
            case "Mercury" -> ay = -3.697;
            case "Venus" -> ay = -8.858;
            case "Mars" -> ay = -3.77;
            case "Jupiter" -> ay = -24.5;
            case "Saturn" -> ay = -11.08;
            case "Uranus" -> ay = -10.67;
            case "Neptune" -> ay = -14.7;
            default -> ay = -9.8;
        }

        System.out.println(ay);

        // Calculate x and y initial velocities
        vix = calcVix(angle);
        viy = calcViy(angle);

        System.out.println("vix: " + vix);
        System.out.println("viy: " + viy);

        calculateProjectile();

        optimalAng = optimalAngle();
        System.out.println(optimalAng);

        // Reset display

        plotRelatedAngles();
    }

    /**
     * Calculates the initial x-velocity
     *
     * @return the initial x-velocity
     */
    private static double calcVix(double ang) {
        return vi * Math.cos(Math.toRadians(ang));
    }

    /**
     * Calculates the initial y-velocity
     *
     * @return the initial y-velocity
     */
    private static double calcViy(double ang) {
        return vi * Math.sin(Math.toRadians(ang));
    }


    /**
     * Calculates x and y positions to trace the path of the projectile until it hits the ground
     */
    private static void calculateProjectile() {
        double t = 0.0;

        try (FileWriter fw = new FileWriter(
            String.format("src/main/resources/angry_robots/ar_%d-%d.txt",
                (int) vi, (int) angle
            ))) {

            while (true) {
                double y = viy * t + 0.5 * ay * Math.pow(t, 2);
                double x = vix * t;
                // If y < 0, break
                if (y < 0) {
                    break;
                }

                // Print values
                System.out.println("x=" + x + ", y=" + y + ", t=" + t);
                fw.write(String.format("%f%n%f%n%n", x, y));

                // Increment t
                t += INCT;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Determines optimal angle for maximum range by testing angles between 0-90 for a set initial
     * velocity.
     *
     * @return the optimal angle (in degrees)
     */
    private static int optimalAngle() {
        // Initialize optimal angle
        int optimalAng = -1;
        double optimalValue = 0;

        for (int a = 0; a <= 90; a++) {

            double t = 0.0;
            vix = calcVix(a);
            viy = calcViy(a);

            double y;
            double x;
            while (true) {
                y = viy * t + 0.5 * ay * Math.pow(t, 2);
                x = vix * t;
                // If y < 0, break
                if (y < 0) {
                    break;
                }

                if (x > optimalValue) {
                    optimalValue = x;
                    optimalAng = a;
                }

                // Increment t
                t += INCT;
            }
            System.out.println(a + ", " + x);
        }

        return optimalAng;
    }

    /**
     * Plot related angles to the optimal angle
     */
    private static void plotRelatedAngles() {
        int[] angles = {optimalAng, optimalAng - 15, optimalAng + 15, optimalAng - 30,
            optimalAng + 30};
        for (int a : angles) {
            angle = a;
            vix = calcVix(a);
            viy = calcViy(a);
            calculateProjectile();
        }
    }
}
