package com.gyoge.itcsgraphics.animators;

import com.gyoge.itcsgraphics.drawables.Drawable;
import com.gyoge.itcsgraphics.drawables.Snowflake;

import java.util.HashMap;

/**
 * Animator for a snowflake.
 * <p>
 * This animator will have the snowflake move down and then wrap back to the top while
 * accelerating.
 *
 * @author Yogesh Thambidurai
 * @see Snowflake
 * @see Animator
 */
public class SnowflakeAnimator implements Animator {

    /** @see Animator#drawable */
    private final Snowflake drawable;
    /** The string used in the params to signify the y acceleration. */
    private final String dy;
    /** The string used in the params to signify the x acceleration. */
    private final String dx;

    /**
     * Constructor for the SnowflakeAnimator.
     *
     * @param x  The x coordinate of the snowflake.
     * @param y  The y coordinate of the snowflake.
     * @param dx The keyword for the x acceleration.
     * @param dy The keyword for the y acceleration.
     */
    public SnowflakeAnimator(int x, int y, String dx, String dy) {
        drawable = new Snowflake(x, y);
        this.dx = dx;
        this.dy = dy;
    }

    /** {@inheritDoc} */
    @Override
    public Drawable getDrawable(HashMap<String, Object> params) {
        this.drawable.setX(drawable.getX() + (double) params.get(dx));
        double newY = drawable.getY() + (double) params.get(dy);

        if (newY - 10 > (int) params.get("HEIGHT")) {
            this.drawable.setY(0);
        } else {
            this.drawable.setY(newY);
        }

        return this.drawable;
    }


}
