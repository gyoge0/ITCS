package com.gyoge.itcsgraphics.animators;

import com.gyoge.itcsgraphics.drawables.Drawable;
import com.gyoge.itcsgraphics.drawables.Spaceship;

import java.util.HashMap;

/**
 * An animator for a spaceship.
 *
 * @author Yogesh Thambidurai
 * @see Spaceship
 */
public class SpaceshipAnimator implements Animator {

    private final Spaceship drawable = new Spaceship();
    private final String dy;
    /** If the spaceship is going down. */
    private boolean goingDown = false;
    /** The dY when going down. */
    @SuppressWarnings("SpellCheckingInspection")
    private int privDy = 0;

    public SpaceshipAnimator(int x, int y, String dy) {
        this.drawable.setX(x);
        this.drawable.setY(y);
        this.dy = dy;
    }

    @SuppressWarnings({"DuplicateCondition", "ConstantConditions"})
    @Override
    public Drawable getDrawable(HashMap<String, Object> params) {
        double newY = this.drawable.getY() + (double) params.get(this.dy);
        if (newY > 400 && goingDown) {
            privDy = 0;
            this.drawable.setY(this.drawable.getY() + 1);
            goingDown = false;
        } else if (newY < 0 || goingDown) {
            privDy += 1;

            this.drawable.setY(this.drawable.getY() + privDy);
            goingDown = true;
        } else if (!goingDown) {
            this.drawable.setY(newY);
        }

        return this.drawable;
    }
}
