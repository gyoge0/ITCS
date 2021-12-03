package robots;

import edu.fcps.karel2.Display;

public class SuperClimber extends Athlete {

    /*
     * Constructors
     */

    public SuperClimber() {
        super(1, 1, Display.NORTH, Display.INFINITY);
    }

    public SuperClimber(int dir) {
        super(0, 0, dir, Display.INFINITY);
    }

    public SuperClimber(int x, int y) {
        super(x, y, Display.NORTH, Display.INFINITY);
    }

    public SuperClimber(int x, int y, int dir) {
        super(x, y, dir, Display.INFINITY);
    }

    public SuperClimber(int x, int y, int dir, int beepers) {
        super(x, y, dir, beepers);
    }

    /*
     * Methods
     */

    public void climbUntil(int untilX) {
        /*
         * Wrapper method that calls climbRight() and climbLeft() based on robot's x and
         * untilX
         */

        if (x < untilX) {
            climbRight(untilX);
        } else {
            climbLeft(untilX);
        }
    }

    private void climbRight(int untilX) {
        /*
         * Climb to the right
         * 
         * Assuming robot is facing right, reach untilX, head to base at untilX, and
         * then face right
         */
        while (x != untilX) {

            if (rightIsClear()) {

                do {
                    turnRight();
                    move();
                    turnLeft();
                } while (!rightIsClear());

            } else if (leftIsClear() && frontIsClear()) {
                // Start going down

                move();
                turnRight();
                while (frontIsClear()) {
                    move();
                }
                turnLeft();

            } else if (leftIsClear()) {

                do {
                    turnLeft();
                    move();
                    turnRight();
                } while (!frontIsClear());

                move();

            } else if (frontIsClear()) {

                move();

            }

        }

    }

    private void climbLeft(int untilX) {
        /*
         * Climb to the left
         * 
         * Assuming robot is facing left, reach untilX, head to base at untilX, and then
         * face left
         */
        while (x != untilX) {

            if (leftIsClear()) {
                do {
                    turnLeft();
                    move();
                    turnRight();
                } while (!leftIsClear());
                // here chang invert stuff

            } else if (rightIsClear() && frontIsClear()) {
                // Start going down
                move();
                turnLeft();
                while (frontIsClear()) {
                    move();
                }
                turnRight();
            } else if (rightIsClear()) {
                do {
                    turnRight();
                    move();
                    turnLeft();
                } while (!frontIsClear());

                move();
            } else if (frontIsClear()) {
                move();
            }

        }
    }
}
