// Yogesh Thambidurai ITCS

package apps;

import robots.Climber;

public class Mountain {

    // Utility class; Shouldn't be instantiated.
    private Mountain() {
        throw new IllegalStateException("Utility Class");
    }

    // looks for a beeper at the top of one of the
    // mountain peaks.
    public static void explore(Climber climby) {

        climby.putBeeper();
        climby.turnLeft();

        // climb left mountain
        exploreWest(climby);

        // climb right mountain, if necessary
        if (!climby.hasBeepers()) {
            exploreEast(climby);
        }

        climby.pickBeeper();
    }

    // climb the western mountain, looking for a beeper at its peak
    private static void exploreWest(Climber climber) {
        int levelsClimbed = 0;

        // get to the mountain
        while (climber.frontIsClear()) {
            climber.move();
        }

        // climb to the top of the mountain
        // count the number of levels climbed
        while (!climber.frontIsClear()) {
            climber.climbUpLeft();
            levelsClimbed++;
        }

        // check for a beeper at the mountain's top
        if (climber.nextToABeeper()) {
            climber.pickBeeper();
        }

        climber.turnAround();

        // go back down the mountain
        for (int i = 0; i < levelsClimbed; i++) {
            climber.climbDownRight();
        }

        // go back to the beeper at "base camp"
        while (!climber.nextToABeeper()) {
            climber.move();
        }
    }

    // climb the eastern mountain, looking for a beeper at its peak
    private static void exploreEast(Climber climber) {
        int levelsClimbed = 0;

        // get to the mountain
        while (climber.frontIsClear()) {
            climber.move();
        }

        // climb the top of the mountain
        // count the number of levels climbed
        while (!climber.frontIsClear()) {
            climber.climbUpRight();
            levelsClimbed++;
        }

        // look for a beeper
        if (climber.nextToABeeper()) {
            climber.pickBeeper();
        }

        climber.turnAround();

        // go back down the mountain
        for (int i = 0; i < levelsClimbed; i++) {
            climber.climbDownLeft();
        }

        // get back to the beeper at "base camp"
        while (!climber.nextToABeeper()) {
            climber.move();
        }
    }
}