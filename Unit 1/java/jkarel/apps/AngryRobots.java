// Yogesh Thambidurai ITCS

package apps;

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

import javax.swing.JOptionPane;

public class AngryRobots {

    private static double vi;

    private static double vix;
    private static double viy;

    private static int optimalAng;

    private static double ay;

    // Time increment
    private static final double INCT = 0.1;

    public static void main(String[] args) {

        // User input to define initial velocity and launch angle
        // the parseDouble method converts the string input to a double
        vi = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial velocity in m/s"));
        double ang = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial angle in degrees"));

        String[] planets = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
        switch ((String) JOptionPane.showInputDialog(null, "Choose a planet.", "Planets", JOptionPane.PLAIN_MESSAGE,
                null, planets, planets[0])) {

        case "Mercury":
            ay = -3.697;
            break;
        case "Venus":
            ay = -8.858;
            break;
        case "Earth":
            ay = -9.8;
            break;
        case "Mars":
            ay = -3.77;
            break;
        case "Jupiter":
            ay = -24.5;
            break;
        case "Saturn":
            ay = -11.08;
            break;
        case "Uranus":
            ay = -10.67;
            break;
        case "Neptune":
            ay = -14.7;
            break;
        default:
            ay = -9.8;
            break;
        }

        System.out.println(ay);

        // Calculate x and y initial velocities
        vix = calcVix(ang);
        viy = calcViy(ang);

        System.out.println("vix: " + vix);
        System.out.println("viy: " + viy);

        calculateProjectile();

        optimalAng = optimalAngle();
        System.out.println(optimalAng);

        // Reset display
        Display.openDefaultWorld();

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
     * Finds the x-coordinate with the initial x-velocity, at the given time, t.
     * 
     * @param t the given time
     * 
     * @return the x-coordinate with the initial x-velocity at the given time
     */
    private static double calcX(double t) {
        return vix * t;
    }

    /**
     * Finds the y-coordinate with the initial y-velocity, at the given time, t.
     * 
     * @param t the given time
     * 
     * @return the y-coordinate with the initial y-velocity at the given time
     */
    private static double calcY(double t) {
        return viy * t + 0.5 * ay * Math.pow(t, 2);
    }

    /**
     * Calculates x and y positions to trace the path of the projectile until it
     * hits the ground
     */
    private static void calculateProjectile() {
        Display.setSize((int) (Math.pow(vi, 2) / 10), (int) (Math.pow(vi, 2) / 10));
        Display.setSpeed(10);
        double t = 0.0;

        while (true) {
            double y = viy * t + 0.5 * ay * Math.pow(t, 2);
            double x = vix * t;
            // If y < 0, break
            if (y < 0) {
                break;
            }

            // Print values
            System.out.println("x=" + x + ", y=" + y + ", t=" + t);

            // Plot robot
            // There is a method for this but its one line just like before and its still
            // understandable
            new Robot((int) x, (int) y, Display.SOUTH, Display.INFINITY);

            // Increment t
            t += INCT;
        }

    }

    /**
     * Declares and instantiates a robot at the given point (x, y)
     * 
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    private static void plotProjectile(double x, double y) {
        new Robot((int) x, (int) y, Display.SOUTH, Display.INFINITY);
    }

    /**
     * Determines optimal angle for maximum range by testing angles between 0-90 for
     * a set initial velocity.
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
        int[] angles = { optimalAng, optimalAng - 15, optimalAng + 15, optimalAng - 30, optimalAng + 30 };
        for (int a : angles) {
            vix = calcVix(a);
            viy = calcViy(a);
            calculateProjectile();
        }
    }

}