// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;

import robots.Athlete;

public class LoopChallenge {

    public static void main(String[] args) {

        Display.openWorld("maps/loopChallenge.map");
        Display.setSize(10, 10);
        Display.setSpeed(10);

        Athlete asdf = new Athlete(1, 1, Display.EAST, 0);

        for (int i = 0; i < 4; i++) {
            asdf.move();
            for (int j = 0; j < 20; j++) {
                asdf.pickBeeper();
            }
            asdf.move();
        }

    }

}