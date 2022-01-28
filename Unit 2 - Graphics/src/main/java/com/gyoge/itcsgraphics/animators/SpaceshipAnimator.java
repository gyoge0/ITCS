package com.gyoge.itcsgraphics.animators;

import com.gyoge.itcsgraphics.drawables.Drawable;
import com.gyoge.itcsgraphics.drawables.Spaceship;

import java.util.HashMap;

public class SpaceshipAnimator implements Animator {

    private final Spaceship drawable = new Spaceship();
    private int startY = 0;

    public SpaceshipAnimator(int x, int y) {
        this.drawable.setX(x);
        this.drawable.setY(y);
        this.startY = y;
    }

    @Override
    public Drawable getDrawable(HashMap<String, Object> params) {
        this.drawable.setY(startY + (int) params.get("dy"));
        this.drawable.setX((int) params.get("WIDTH") / 2);

        return this.drawable;
    }
}
