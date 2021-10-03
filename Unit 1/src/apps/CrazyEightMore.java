// Yogesh Thambidurai ITCS

package apps;

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class CrazyEightMore {
    public static void main(String[] args) {
        String[] choices = { "eightMore1", "eightMore2", "eightMore3", "eightMore4" };
        String filename = (String) JOptionPane.showInputDialog(null, "Choose a map.", "Map Choices",
                JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
        Display.openWorld("Unit 1/lib/Jkarel Start Files/maps/" + filename + ".map");
        Display.setSize(10, 10);
        Display.setSpeed(10);

        task_09(); // put down 5 different piles with 4 beepers in each pile. Use definte loops
        task_10(); // fill in the gaps with a beeper and stop when you reach a wall
        task_11(); // As long as there is a wall to your right, put down one beeper at each step
        task_12(); // go until there is a wall to your right and you are standing on a beeper

        task_13(); // Go to the wall. Only pick up 1 beeper in each pile, if there is a pile.
        task_14(); // Go to the beeper. Count and print out the number of walls you pass.
        task_15(); // Go to the wall. Pick up all the beepers (max 1 per pile) and put down a
                   // beeper in any gap.

        task_16(); // Pick up the row of beepers (max 1 per pile). Then return ONE space before the
                   // original starting position. You may NOT get to the wall, turn around, and go
                   // back one spot.

    }

    // Put down 5 different piles with 4 beepers in each pile. Use definte loops
    public static void task_09() {
        Robot temp = new Robot(1, 1, Display.EAST, 20);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                temp.putBeeper();
            }
            if (temp.frontIsClear()) {
                temp.move();
            }
        }

    }

    // Fill in the gaps with a beeper and stop when you reach a wall
    public static void task_10() {
        Robot temp = new Robot(1, 2, Display.EAST, Display.INFINITY);

        while (temp.frontIsClear()) {
            if (!temp.nextToABeeper()) {
                temp.putBeeper();
            }
            temp.move();
        }
        if (!temp.nextToABeeper()) {
            temp.putBeeper();
        }
    }

    // As long as there is a wall to your right, put down one beeper at each step
    public static void task_11() {
        Robot temp = new Robot(1, 3, Display.EAST, Display.INFINITY);

        while (!temp.rightIsClear()) {
            temp.putBeeper();
            if (temp.frontIsClear()) {
                temp.move();
            }
        }

    }

    // Go until there is a wall to your right and you are standing on a beeper
    public static void task_12() {
        Robot temp = new Robot(1, 4, Display.EAST, 0);

        while (!(!temp.rightIsClear() && temp.nextToABeeper())) {
            temp.move();
        }
    }

    // Go to the wall. Only pick up 1 beeper in each pile, if there is a pile.
    public static void task_13() {
        Robot temp = new Robot(1, 5, Display.EAST, 0);

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

    // Go to the beeper. Count and print out the number of walls you pass.
    public static void task_14() {
        Robot temp = new Robot(1, 6, Display.EAST, 0);

        int count = 0;
        while (!temp.nextToABeeper()) {
            if (!temp.leftIsClear()) {
                count++;
            }
            if (!temp.rightIsClear()) {
                count++;
            }
            temp.move();
        }

        System.out.println("I passed " + count + " walls.");
    }

    // Go to the wall. Pick up all the beepers (max 1 per pile) and put down a
    // beeper in any gap.
    public static void task_15() {
        Robot temp = new Robot(1, 7, Display.EAST, Display.INFINITY);

        while (temp.frontIsClear()) {
            if (temp.nextToABeeper()) {
                temp.pickBeeper();
            } else {
                temp.putBeeper();
            }

            temp.move();
        }

        if (temp.nextToABeeper()) {
            temp.pickBeeper();
        } else {
            temp.putBeeper();
        }
    }

    // Pick up the row of beepers (max 1 per pile). Then return ONE space before the
    // original starting position. You may NOT get to the wall, turn around, and go
    // back one spot.
    public static void task_16() {
        Robot temp = new Robot(1, 8, Display.EAST, 0);

        int spaces = 0;

        while (temp.nextToABeeper()) {
            temp.pickBeeper();
            temp.move();
            spaces++;
        }
        temp.turnLeft();
        temp.turnLeft();
        for (int i = 0; i < spaces - 1; i++) {
            temp.move();
        }
    }
}