package com.gyoge.itcsgraphics.drawables;

import java.awt.Graphics;

/**
 * Drawable
 * <p>
 * An interface for objects that can be drawn to any (x, y) coordinate with a graphics object. Can
 * be animated via an Animator.
 *
 * @author Yogesh Thambidurai
 * @see com.gyoge.itcsgraphics.animators.Animator
 */
@SuppressWarnings("unused")
public interface Drawable {

    double x = 0;
    double y = 0;

    void setX(double x);

    void setY(double y);

    double getX();

    double getY();

    void draw(Graphics goon);
}
