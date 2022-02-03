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
     * Getter for x.
     *
     * @return The x coordinate of the drawable.
     */
    double getX();

    /**
     * Setter for x.
     *
     * @param x The new x coordinate of the drawable.
     */
    void setX(double x);

    /**
     * Getter for y.
     *
     * @return The y coordinate of the drawable.
     */
    double getY();

    /**
     * Setter for y.
     *
     * @param y The new y coordinate of the drawable.
     */
    void setY(double y);

    /**
     * Draw the drawable to the graphics object.
     *
     * @param goon The graphics object to draw to.
     */
    void draw(Graphics goon);
}
