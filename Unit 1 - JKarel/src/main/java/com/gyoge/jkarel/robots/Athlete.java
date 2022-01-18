// Yogesh Thambidurai ITCS
package com.gyoge.jkarel.robots;

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Athlete extends Robot {

    public Athlete() {
        super(1, 1, Display.NORTH, Display.INFINITY);
    }

    public Athlete(int x, int y, int dir, int beepers) {
        super(x, y, dir, beepers);
    }

    // Turn right
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    // Turn 180 degrees
    public void turnAround() {
        turnLeft();
        turnLeft();
    }

}
