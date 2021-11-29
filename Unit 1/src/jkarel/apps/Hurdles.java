package apps;

import edu.fcps.karel2.Display;

import robots.Racer;
import robots.HighJumper;
import robots.BoxTopper;

import javax.swing.JOptionPane;

public class Hurdles {
    // declare and initialize array of map choices for the dialogue drop-down
    // options
    // private static final String[] choices = { "racerTest", "highjumpTest",
    // "boxtopTest" };
    private static final String[] choices = { "hurdle1", "hurdle2", "hurdle3", "steeple1", "steeple2", "steeple3",
            "boxtop1", "boxtop2", "boxtop3" };

    public static void main(String[] args) {
        // open dialogue box and request user input of map choices
        String mapChoice = (String) JOptionPane.showInputDialog(null, "Choose a map.", "Map Choices",
                JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

        // open selected map and set size and speed
        Display.openWorld("Unit 1/lib/Jkarel Start Files/maps/" + mapChoice + ".map");
        Display.setSize(18, 10);
        Display.setSpeed(10);

        Racer turbo;

        if (mapChoice.startsWith("hurdle")) {
            turbo = new Racer(1);
        } else if (mapChoice.startsWith("steeple")) {
            turbo = new HighJumper(1);
        } else {
            turbo = new BoxTopper(1);
        }

        race(turbo);

        // if (mapChoice.equals("racerTest")) {
        // turbo = new Racer(1);
        // } else if (mapChoice.equals("highjumpTest")) {
        // turbo = new HighJumper(1);
        // } else {
        // turbo = new BoxTopper(1);
        // }

        // raceTest(turbo);
        // System.out.println("test complete");

    }

    private static void race(Racer r) {
        while (r.frontIsClear()) {
            if (r.nextToABeeper()) {
                break;
            }
            r.move();
        }
        while (!r.nextToABeeper()) {
            r.jumpRight();
            while (r.frontIsClear()) {
                if (r.nextToABeeper()) {
                    break;
                }
                r.move();
            }
        }
        System.out.println("done");
    }

    // Test the jumpRight method.
    // The racer will move, move, then jumpRight and jump over the hurdle.
    // The racer will finish next to the hurdle, facing to the east (right).
    // private static void raceTest(Racer racer) {
    // racer.move();
    // racer.move();
    // racer.jumpRight();

    // }
}