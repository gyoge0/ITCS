// Yogesh Thambidurai ITCS
package robots;

import edu.fcps.karel2.Display;

// A Climber Robot can climb up and down mountain
public class Climber extends Athlete {

    // The default constructor starts at (1,1), faces North, and has
    // 1 beeper
    public Climber() {
        super(1, 1, Display.NORTH, 1);
    }

    // Start at specified x, face north, 1 beeper
    public Climber(int x) {
        super(x, 1, Display.NORTH, 1);
    }

    // Climber is facing right and moves up one level and finishes facing right
    public void climbUpRight() {
        turnLeft();
        move();
        move();
        turnRight();
        move();
    }

    // Climber is facing left and moves up one level and finishes facing left
    public void climbUpLeft() {
        turnRight();
        move();
        move();
        turnLeft();
        move();
    }

    // Climber is facing right and moves down one level and finishes facing right
    public void climbDownRight() {
        move();
        turnRight();
        move();
        move();
        turnLeft();
    }

    // Climber is facing left and moves down one level and finishes facing right
    public void climbDownLeft() {
        move();
        turnLeft();
        move();
        move();
        turnRight();
    }
}