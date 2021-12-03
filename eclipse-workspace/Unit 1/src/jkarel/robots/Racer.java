// Yogesh Thambidurai ITCS
package robots;

import edu.fcps.karel2.Display;

public class Racer extends Athlete {
    // A Racer can be at any y-coordinate (1, y), face East,
    // and have an Infinite amount of beepers
    public Racer(int y) {
        super(1, y, Display.EAST, Display.INFINITY);
    }

    // Begins facing East, jumps over a hurdle, and finishes facing East
    public void jumpRight() {
        turnLeft();
        move();
        turnRight();
        move();
        turnRight();
        move();
        turnLeft();
    }

    // Begins facing West, jumps over a hurdle, and finishes facing West.
    public void jumpLeft() {

        turnRight();
        move();
        turnLeft();
        move();
        turnLeft();
        move();
        turnRight();
    }

    // Moves forward numSpaces spaces.
    public void sprint(int numSpaces) {
        for (int i = 0; i < numSpaces; i++) {
            move();
        }
    }

    // Put down numBeepers beepers.
    public void put(int numBeepers) {
        for (int i = 0; i < numBeepers; i++) {
            putBeeper();
        }
    }

    // Pick up numBeepers beepers.
    public void pick(int numBeepers) {
        for (int i = 0; i < numBeepers; i++) {
            pickBeeper();
        }
    }

    // Starts at x=1, facing east.
    // Jump hurdle, move spaces, pick up beepers, place beepers are starting
    // position
    public void shuttle(int spaces, int beepers) {
        move();
        jumpRight();
        sprint(spaces);
        pick(beepers);
        turnAround();
        sprint(spaces);
        jumpLeft();
        move();
        put(beepers);
        turnAround();
    }

}