// Yogesh Thambidurai ITCS
package robots;

import edu.fcps.karel2.Display;

public class MountainClimber extends SuperRobot {

    public MountainClimber() {
        super(1, 1, Display.NORTH, Display.INFINITY);
    }

    public MountainClimber(int dir) {
        super(0, 0, dir, Display.INFINITY);
    }

    public MountainClimber(int x, int y) {
        super(x, y, Display.NORTH, Display.INFINITY);
    }

    public MountainClimber(int x, int y, int dir) {
        super(x, y, dir, Display.INFINITY);
    }

    public MountainClimber(int x, int y, int dir, int beepers) {
        super(x, y, dir, beepers);
    }

}
