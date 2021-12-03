package testing;

import robots.Athlete;

import java.util.ArrayList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.fcps.karel2.Display;

public class ThreadingTester {
    public static void main(String[] args) {
        Display.openWorld(" ");
        Display.setSize(25, 25);

        ArrayList<ThreadedAthlete> athletes = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            athletes.add(new ThreadedAthlete(i, i, Display.EAST, Display.INFINITY, i));
        }

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (ThreadedAthlete threadedAthlete : athletes) {
            pool.execute(threadedAthlete);
        }
    }
}

class ThreadedAthlete extends Athlete implements Runnable {
    final int movex;

    public ThreadedAthlete(int x, int y, int dir, int beepers, int amount) {
        super(x, y, dir, beepers);
        movex = amount;
    }

    public void run() {
        for (int i = 0; i < movex; i++) {
            move();
        }
    }
}
