// Yogesh Thambidurai ITCS
package robots;

import edu.fcps.karel2.Display;

public class SuperRobot extends MultiTasker {

    /*
     * Constructors
     */

    public SuperRobot() {
        super(1, 1, Display.NORTH, Display.INFINITY);
    }

    public SuperRobot(int dir) {
        super(0, 0, dir, Display.INFINITY);
    }

    public SuperRobot(int x, int y) {
        super(x, y, Display.NORTH, Display.INFINITY);
    }

    public SuperRobot(int x, int y, int dir) {
        super(x, y, dir, Display.INFINITY);
    }

    public SuperRobot(int x, int y, int dir, int beepers) {
        super(x, y, dir, beepers);
    }

    /*
     * Methods
     */

    public void teleport(int teleportX, int teleportY) {
        /*
         * Teleport. x and y are protected, so they can be modified from here.
         * display.step() to update the display isn't accessible from here, so we have
         * to call turnLeft() to update the display. It's called 4 times just to
         * maintain the position.
         */

        x = teleportX;
        y = teleportY;

        turnLeft();
        turnLeft();
        turnLeft();
        turnLeft();

    }

    public void moveX(int spaces) {
        // Move multiple spaces

        for (int i = 0; i < spaces; i++) {
            move();
        }

    }

    public void dropAndMoveX(int spaces) {
        // Drop and then move multiple times

        for (int i = 0; i < spaces; i++) {
            putBeeper();
            move();
        }

    }

    public void moveAndDropX(int spaces) {
        // Move and then drop multiple times

        for (int i = 0; i < spaces; i++) {
            move();
            putBeeper();
        }

    }

    public void moveFrontRight() {
        // Move diagonally to the front and left

        move();
        turnRight();
        move();
        turnLeft();

    }

    public void moveFrontLeft() {
        // Move diagonally to the front and right

        move();
        turnLeft();
        move();
        turnRight();

    }

    public void moveFrontRightX(int spaces) {
        // Move to the front right multiple times

        for (int i = 0; i < spaces; i++) {
            moveFrontRight();
        }

    }

    public void moveFrontLeftX(int spaces) {
        // Move to the front left multiple times

        for (int i = 0; i < spaces; i++) {
            moveFrontLeft();
        }

    }

    public void moveXgrabXAndBack(int x, int amount) {
        for (int i = 0; i < x; i++) {
            move();
        }
        for (int i = 0; i < amount; i++) {
            pickBeeper();
        }
        turnAround();
        for (int i = 0; i < x; i++) {
            move();
        }

    }

}
