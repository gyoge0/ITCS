package robots;

public class BoxTopper extends Racer {
    
    public BoxTopper(int y) {
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
        while (!rightIsClear()) {
            move();
        }
        turnRight();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }
}
