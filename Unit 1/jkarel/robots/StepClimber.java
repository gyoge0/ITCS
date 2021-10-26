package robots;

public class StepClimber extends Climber {

    /*
     * Constructors
     */

    public StepClimber() {
        super();
    }

    public StepClimber(int x) {
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
    }

    @Override
    public void climbUpLeft() {
        turnRight();
        move();
        turnLeft();
        move();
    }

    @Override
    public void climbDownRight() {
        move();
        turnRight();
        move();
        turnLeft();
    }

    @Override
    public void climbDownLeft() {
        move();
        turnLeft();
        move();
        turnRight();
    }
}
