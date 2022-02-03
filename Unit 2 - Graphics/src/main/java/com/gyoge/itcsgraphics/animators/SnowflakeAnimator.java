package com.gyoge.itcsgraphics.animators;

import com.gyoge.itcsgraphics.drawables.Drawable;
import com.gyoge.itcsgraphics.drawables.Snowflake;

import java.util.HashMap;

/**
 * Animator for a snowflake.
 *
 * @author Yogesh Thambidurai
 * @see Snowflake
 */
public class SnowflakeAnimator implements Animator {

    private final Snowflake drawable;
    private final String dy;
    private final String dx;

    public SnowflakeAnimator(int x, int y, String dx, String dy) {
        drawable = new Snowflake(x, y);
        this.dx = dx;
        this.dy = dy;
    }

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
