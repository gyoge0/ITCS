// Yogesh Thambidurai ITCS
package robots;

import edu.fcps.karel2.Display;

public class SuperRobotV3 extends SuperRobotV2 {
    // V3 now implements grab and return

    /*
     * Constructors
     */

    public SuperRobotV3() {
        super(1, 1, Display.NORTH, Display.INFINITY);
    }

    public SuperRobotV3(int dir) {
        super(0, 0, dir, Display.INFINITY);
    }

    public SuperRobotV3(int x, int y) {
        super(x, y, Display.NORTH, Display.INFINITY);
    }

    public SuperRobotV3(int x, int y, int dir) {
        super(x, y, dir, Display.INFINITY);
    }

    public SuperRobotV3(int x, int y, int dir, int beepers) {
        super(x, y, dir, beepers);
    }

    /*
     * Methods
     */

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
