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

    /** The x coordinate of a drawable. Should be casted to int before drawing. */
    double x = 0;
    /** The y coordinate of a drawable. Should be casted to int before drawing. */
    double y = 0;


    /**
     * Draw the drawable to the graphics object.
     *
     * @param goon The graphics object to draw to.
     */
    void draw(Graphics goon);
}
