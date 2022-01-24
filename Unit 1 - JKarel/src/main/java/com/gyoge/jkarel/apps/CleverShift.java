package com.gyoge.jkarel.apps;

import edu.fcps.karel2.Display;
import javax.swing.JOptionPane;
import com.gyoge.jkarel.robots.Athlete;

public class CleverShift {

    private static void shiftBeepers(Athlete a) {
        // Main loop
        for (int i = 0; i < 7; i++) {
            // Pick all beepers
            while (a.nextToABeeper()) {
                a.pickBeeper();
            }
            // Shift one
            a.move();
            // Put all beepers
            while (a.hasBeepers()) {
                a.putBeeper();
            }

            // Go back one space before
            a.turnAround();
            a.move();
            if (a.frontIsClear()) {
                a.move(); // Don't crash into wall!
            }
            // Reset direction
            a.turnAround();
        }
    }

    private static void shiftFirst(Athlete a) {
        // Reach 7, 1
        for (int i = 0; i < 6; i++) {
            a.move();
        }
        shiftBeepers(a);
    }

    private static void shiftAgain(Athlete a) {
        // Reach 2, 1
        a.move();
        a.turnAround();
        shiftBeepers(a);
    }

    public static void main(String[] args) {

        String[] choices = {"pile1", "pile2", "pile3"};
        String filename = (String) JOptionPane.showInputDialog(null, "Choose a map.", "Map Choices",
            JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
        Display.openWorld("maps//" + filename + ".map");
        Display.setSize(10, 10);
        Display.setSpeed(10);

        Athlete a = new Athlete(1, 1, Display.EAST, 0);

        shiftFirst(a);
        System.out.println("Shift done");

        shiftAgain(a);
        System.out.println("Shift again done");
    }
}
