package apps;

import edu.fcps.karel2.Robot;
import edu.fcps.karel2.Display;

import javax.swing.JOptionPane;

public class Calculator2 {
    public static void main(String[] args) {
        // Dialogue box allows user input for the values to be calculated and parses
        // them to doubles
        double value1 = Double.parseDouble(JOptionPane.showInputDialog("Please enter first value"));
        double value2 = Double.parseDouble(JOptionPane.showInputDialog("Please enter second value"));
        double value3 = Double.parseDouble(JOptionPane.showInputDialog("Please enter third value"));

        System.out.println("Get X Component: " + getXComponent(value1, value1));
        System.out.println("Get Y Component: " + getYComponent(value1, value1));
        // Plot Line
        plotLine(value1, value2);
        // Quadratic Solver
        quadraticSolver(value1, value2, value3);
        // Projectile Solver
        projectileSolver(value1, value2);

    }

    private static double getXComponent(double deg, double h) {
        return h * Math.cos(Math.toRadians(deg));
    }

    private static double getYComponent(double deg, double h) {
        return h * Math.sin(Math.toRadians(deg));
    }

    private static void plotLine(double rise, double run) {
        System.out.println("First Five Points\n");
        double m = rise / run;

        for (int i = 1; i <= 5; i++) {
            System.out.println("(" + i + ", " + m * i + ")");
        }

        Display.setSize(20, 20);

        for (int i = 1; i <= 5; i++) {
            new Robot(i, (int) (m * i), Display.NORTH, 0);
        }

    }

    private static void quadraticSolver(double a, double b, double c) {
        System.out.println("For the quadratic equation: " + a + "x^2 + " + b + "x + " + c);
        // I have no idea why, but the sign of the root is always inverted.
        // I spent forever figuring out why and still don't know so I'm just going to
        // multiply by -1 for now.
        System.out.println("The first root is: " + (-1 * ((-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a))));
        System.out.println("The second root is: " + (-1 * (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a)));
    }

    private static void projectileSolver(double vi, double theta) {
        double vix = vi * Math.cos(Math.toRadians(theta));
        double viy = vi * Math.sin(Math.toRadians(theta));

        System.out.println("Initial horizontal velocity: " + vix);
        System.out.println("Initial vertical velocity: " + viy);

        /*
         * Math behind following:
         * 
         * initial: 0 = vi*t + 1/2(-9.8)t^2
         * 
         * evaluate 1/2(-9.8) 0 = vi*t - 4.9t^2
         * 
         * flip equation: vi*t - 4.9t^2 = 0
         * 
         * rearrange terms and add in constant: -4.9t^2 + vi*t + 0 = 0
         * 
         * Quadratic!
         * 
         * add 4.9t^2 to both sides: vi*t = 4.9t^2
         * 
         * divide both sides by t: vi = 4.9t
         * 
         * divide both sides by 4.9 and flip equation:
         * 
         * t = vi/4.9
         */

        double t = vi / 4.9;

        System.out.println("Hang time: " + t);

        /*
         * Math behind following:
         * 
         * x = vixt + 1/2at^2
         * 
         * a is 0, last term is removed:
         * 
         * x = vixt
         */

        double x = vix * t;

        System.out.println("x-range: " + x);
    }
}
