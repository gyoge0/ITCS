// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;
import robots.MultiTasker;

public class MakePyramid3 {

    // The Multitasker will make column of beepers numBeepers high
    private static void goUp(MultiTasker worker, int numBeepers) {
        worker.turnLeft();
        for (int i = 0; i < numBeepers; i++) {
            worker.dropAndMove();
        }

    }

    private static void goBack(MultiTasker worker, int numBeepers) {
        worker.turnAround();
        for (int i = 0; i < numBeepers; i++) {
            worker.move();
        }
        worker.turnLeft();
    }

    private static void moveOver(MultiTasker worker) {
        worker.move();
    }

    public static void main(String[] args) {
        MultiTasker tasker = new MultiTasker(1, 1, Display.EAST, Display.INFINITY);

        for (int i = 1; i <= 10; i++) {
            goUp(tasker, i);
            goBack(tasker, i);
            moveOver(tasker);
        }

    }

}