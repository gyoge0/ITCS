package robots;

public class HillClimber extends Climber {

    /*
     * Constructors
     */

    public HillClimber() {
        super();
    }

    public HillClimber(int x) {
        super(x);
    }

    /*
     * Methods
     */

    @Override
    public void climbUpRight() {
        turnLeft();
        move();
        turnRight();
        move();
        move();
    }

    @Override
    public void climbUpLeft() {
        turnRight();
        move();
        turnLeft();
        move();
        move();
    }

    @Override
    public void climbDownRight() {
        move();
        move();
        turnRight();
        move();
        turnLeft();
    }

    @Override
    public void climbDownLeft() {
        move();
        move();
        turnLeft();
        move();
        turnRight();
    }
}
