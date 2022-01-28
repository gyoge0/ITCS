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
public interface Drawable {

    /** X coordinate to draw at. */
    int x = 0;
    /** Y coordinate to draw at. */
    int y = 0;

    /** Getter for x. */
    int getX();

    /** Setter for x. */
    void setX(int x);

    /** Getter for y. */
    int getY();

    /** Setter for y. */
    void setY(int y);

    /**
     * Draws the object to the graphics object.
     *
     * @param goon Graphics object to draw to.
     */
    void draw(Graphics goon);
}
