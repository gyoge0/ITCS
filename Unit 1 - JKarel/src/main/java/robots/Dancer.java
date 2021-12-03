// Yogesh Thambidurai ITCS

package robots;

import edu.fcps.karel2.Display;

public class Dancer extends Athlete implements Runnable {

    // default constructor
    public Dancer() {
        super(1, 1, Display.NORTH, 0);
    }

    // four argument constructor
    public Dancer(int x, int y, int direction, int beepers) {
        super(x, y, direction, beepers);
    }

    // One argument constructor
    public Dancer(int x) {
        super(x, 1, Display.EAST, 0);
    }


    // regular dancers just spin in place
    // how boring
    public void dance() {
        turnLeft();
        turnLeft();
        turnLeft();
        turnLeft();
    }

    // execute danceStep() at least 10 times
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.dance();
        }
    }

}