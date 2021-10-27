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

    // quadratic solver
    // given a, b, and c as doubles, print the 2 roots
    private static void quadraticSolver(double a, double b, double c) {
        double root1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        double root2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        System.out.println("\nQuadratic Solver\n");
        System.out.println("Root 1: " + root1);
        System.out.println("Root 2: " + root2);
    }

    // projectile solver
    // given initial velocity and launch angle, print the original horizontal
    // velocity, orignial vertical velocity, and the time to hit the ground
    private static void projectileSolver(double v, double angle) {
        double vx = v * Math.cos(Math.toRadians(angle));
        double vy = v * Math.sin(Math.toRadians(angle));
        double t = vy / 9.8;
        System.out.println("\nProjectile Solver\n");
        System.out.println("Horizontal Velocity: " + vx);
        System.out.println("Vertical Velocity: " + vy);
        System.out.println("Time to Hit Ground: " + t);
    }

}
