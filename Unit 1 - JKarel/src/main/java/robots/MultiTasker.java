// Yogesh Thambidurai ITCS
package robots;

import edu.fcps.karel2.Display;

public class MultiTasker extends Athlete {

    public MultiTasker() {
        super(1, 1, Display.NORTH, Display.INFINITY);
    }

    public MultiTasker(int x, int y, int dir, int beepers) {
        super(x, y, dir, beepers);
    }

    public void dropAndMove() {
        putBeeper();
        move();
    }

    public void moveAndDrop() {
        move();
        putBeeper();
    }

}
