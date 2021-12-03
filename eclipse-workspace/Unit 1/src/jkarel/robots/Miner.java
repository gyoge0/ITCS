// Yogesh Thambidurai ITCS
package robots;

import edu.fcps.karel2.Robot;

public class Miner extends Robot {
	// Miner starts at (1, 1) faces East, and has no beepers.
	public Miner() {
		super();
	}

	// Miners starts at any location (x, y), faces any direction (dir),
	// and has the specified amound of beepers (beep).
	public Miner(int x, int y, int dir, int beep) {
		super(x, y, dir, beep);
	}

	// Overrides the turnLeft() method from Robot so the Miner
	// cannot turnLeft.
	public void turnLeft() {

	}

}