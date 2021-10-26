// Yogesh Thambidurai ITCS
package testing;

import edu.fcps.karel2.Display;

import robots.Racer;

import java.util.ArrayList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShuttleRun {

    public static void main(String[] args) {

        Display.openWorld("Unit 1/lib/Jkarel Start Files/maps/shuttlerun.map");
        Display.setSize(13, 10);
        Display.setSpeed(10);

        ArrayList<ThreadedRacer> racers = new ArrayList<>();
        racers.add(new ThreadedRacer(1));
        racers.add(new ThreadedRacer(4));
        racers.add(new ThreadedRacer(7));

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (ThreadedRacer threadedRacer : racers) {
            pool.execute(threadedRacer);
        }

    }

}

class ThreadedRacer extends Racer implements Runnable {

    public ThreadedRacer(int y) {
        super(y);
    }

    public void run() {
        shuttle(3, 5);
        shuttle(5, 2);
        shuttle(6, 3);
        shuttle(9, 7);
        move();
    }
}
