// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;

import robots.Racer;

public class ShuttleRun {

    public static void runTheRace(Racer racer) {

        racer.shuttle(3, 5);
        racer.shuttle(5, 2);
        racer.shuttle(6, 3);
        racer.shuttle(9, 7);
        racer.move();

    }

    public static void main(String[] args) {

        Display.openWorld("lib/Jkarel Start Files/maps/shuttlerun.map");
        Display.setSize(13, 10);
        Display.setSpeed(10);

        Racer one = new Racer(1);
        Racer two = new Racer(4);
        Racer three = new Racer(7);

        runTheRace(one);
        runTheRace(two);
        runTheRace(three);

    }
}