package robots;

public class HighJumper extends Racer {

    public HighJumper(int y) {
        super(y);
    }

    // TODO: remove override

    // Facing east
    @Override
    public void jumpRight() {
        turnLeft();
        while (!rightIsClear()) {
            move();
        }
        turnRight();
        move();
        turnRight();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }

}
