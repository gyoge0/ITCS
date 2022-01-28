package com.gyoge.itcsgraphics.animators;

import com.gyoge.itcsgraphics.drawables.Drawable;
import com.gyoge.itcsgraphics.drawables.Snowflake;

import java.util.HashMap;

public class SnowflakeAnimator implements Animator {

    private final Snowflake drawable;

    public SnowflakeAnimator(int x, int y) {
        drawable = new Snowflake(x, y);
    }

    @Override
    public Drawable getDrawable(HashMap<String, Object> params) {
        this.drawable.setX(drawable.getX() + (int) params.get("dx"));
        this.drawable.setY(drawable.getY() + (int) params.get("dy"));

        return this.drawable;
    }


}
