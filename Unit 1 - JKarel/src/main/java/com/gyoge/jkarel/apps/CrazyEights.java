// Yogesh Thambidurai ITCS
package com.gyoge.jkarel.apps;

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class CrazyEights {

    public static void main(String[] args) {

        String[] choices = {"eightTasks1", "eightTasks2", "eightTasks3", "eightTasks4"};

        String filename = (String) JOptionPane.showInputDialog(null, "Choose a map.", "Map Choices",
            JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

        Display.openWorld("maps//" + filename + ".map");
        Display.setSize(10, 10);
        Display.setSpeed(10);

        task01(); // go to the end of the row of beepers
        task02(); // go to the beeper
        task03(); // go to the wall
        task04(); // go to the wall, pick up all the beepers (max one per pile)

        task05(); // go to the wall, pick up all the beepers
        task06(); // go to the end of the row of beepers, there is one gap exactly one beeper wide
        task07(); // go to the beeper or the wall. Count and report the number of steps robot
        // took.
        task08(); // go until you are next to another robot, then put all your beepers down.

    }

    // Go to the end of the row of beepers
    private static void task01() {
        Robot temp = new Robot(1, 1, Display.EAST, 0);

        while (temp.nextToABeeper()) {
            temp.move();
        }
        temp.turnLeft();
        temp.turnLeft();
        temp.move();
        temp.turnLeft();
        temp.turnLeft();

    }

    // Go to the beeper
    private static void task02() {
        Robot temp = new Robot(1, 2, Display.EAST, 0);

        while (!temp.nextToABeeper()) {
            temp.move();
        }

    }

    // Go to the wall
    private static void task03() {
        Robot temp = new Robot(1, 3, Display.EAST, 0);

        while (temp.frontIsClear()) {
            temp.move();
        }

    }

    // Go to the wall, pick up all the beepers (max one per pile)
    private static void task04() {
        Robot temp = new Robot(1, 4, Display.EAST, 0);

        while (temp.frontIsClear()) {
            if (temp.nextToABeeper()) {
                temp.pickBeeper();
            }

            temp.move();
        }

        if (temp.nextToABeeper()) {
            temp.pickBeeper();
        }

    }

    // Go to the wall, pick up all the beepers
    private static void task05() {
        Robot temp = new Robot(1, 5, Display.EAST, 0);

        while (temp.frontIsClear()) {
            while (temp.nextToABeeper()) {
                temp.pickBeeper();
            }

            temp.move();
        }

        while (temp.nextToABeeper()) {
            temp.pickBeeper();
        }

    }

    // Go to the end of the row of beepers, there is one gap exactly one beeper wide
    private static void task06() {
        Robot temp = new Robot(1, 6, Display.EAST, 0);

        boolean passedgap = false;

        // haha infinite loop
        while (true) {
            if (temp.nextToABeeper() || !passedgap) {
                if (!temp.nextToABeeper()) {
                    passedgap = true;
                }
                temp.move();
            } else {
                break;
            }
        }
        temp.turnLeft();
        temp.turnLeft();
        temp.move();
        temp.turnLeft();
        temp.turnLeft();

    }

    // Go to the beeper or the wall. Count and report the number of steps robot
    // took.
    private static void task07() {
        Robot temp = new Robot(1, 7, Display.EAST, 0);

        int spaces = 0;

        while (temp.frontIsClear() && !temp.nextToABeeper()) {
            temp.move();
            spaces++;
        }
        System.out.println("I moved " + spaces + " spaces.");

    }

    // Go until you are next to another robot, then put all your beepers down.
    private static void task08() {
        int beepers = (int) (Math.random() * 21); // creates a random number between 0 and 20
        Robot temp = new Robot(1, 8, Display.EAST, beepers);

        int xcoord = (int) (Math.random() * 10 + 1); // creates a random number between 1 and 10
        new Robot(xcoord, 8, Display.WEST, 0);

        // Your code goes here for temp to walk towards randomRobo

        while (temp.getX() != xcoord) {
            temp.move();
        }

        for (int dropped = 1; dropped <= beepers; dropped++) {
            temp.putBeeper();
        }

    }

}
