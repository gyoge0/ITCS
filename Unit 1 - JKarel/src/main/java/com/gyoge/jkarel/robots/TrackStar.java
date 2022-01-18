// Yogesh Thambidurai ITCS

package com.gyoge.jkarel.robots;

import edu.fcps.karel2.Display;

public class TrackStar extends Athlete {

    private final String name;
    private int steps = 0;
    private int laps = 0;

    /*
     * Creates a TrackStar with the given name at (1, 1), facing East, with 0
     * beepers
     *
     * @param name the name of the TrackStar
     */
    public TrackStar(String name) {
        super(1, 1, Display.EAST, 0);
        this.name = name;
    }

    /*
     * runLap
     *
     * Runs exactly one lap. Use moveAndCount to move Add one to the number of laps
     * run. The TrackStar will begin facing East and finish facing East.
     */
    public void runLap() {
        for (int i = 0; i < 4; i++) {
            while (frontIsClear()) {
                moveAndCount();
            }
            turnLeft();
        }
        laps++;
    }

    /*
     * moveAndCount
     *
     * Moves one space and counts every step taken
     */
    public void moveAndCount() {
        move();
        steps++;
    }

    /*
     * getSteps
     *
     * @return the number of steps taken
     */
    public int getSteps() {
        return steps;
    }

    /*
     * getLaps
     *
     * @return the number of laps run
     */
    public int getLaps() {
        return laps;
    }

    /*
     * calculateMiles
     *
     * Returns the number of miles ran, rounded down. One mile equals 20 steps.
     *
     * @return the number of miles ran, rounded down
     */
    public int calculateMiles() {
        return steps / 20;
    }

    /*
     * getName
     *
     * @return the name of the TrackStar
     */
    public String getName() {
        return name;
    }

    /*
     * resetCount
     *
     * Resets the number of steps taken to 0. Resets the number of laps taken to 0.
     */
    public void resetCount() {
        steps = 0;
        laps = 0;
    }

    /*
     * warmUp
     *
     * Runs the specified number of laps by numLaps. Call runLap, do not re-write
     * lap running code
     *
     * @param numLaps the number of laps to run
     */
    public void warmUp(int numLaps) {
        for (int i = 0; i < numLaps; i++) {
            runLap();
        }
    }

}
