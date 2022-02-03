package com.gyoge.itcsgraphics.drawables;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * Spaceship
 * <p>
 * A spaceship with an image of Dwayne "The Rock" Johnson in it.
 *
 * @author Yogesh Thambidurai
 * @see com.gyoge.itcsgraphics.animators.SpaceshipAnimator
 * @see Drawable
 */
@SuppressWarnings("unused")
public class Spaceship implements Drawable {

    /** @see Drawable#x */
    private double x = 0;
    /** @see Drawable#y */
    private double y = 0;

    /** The width of the rocket. */
    private int width = 50;
    /** The height of the rocket. */
    private int height = 100;

    /** {@inheritDoc} */
    public int getWidth() {
        return width;
    }

    /** {@inheritDoc} */
    public void setWidth(int width) {
        this.width = width;
    }

    /** {@inheritDoc} */
    public int getHeight() {
        return height;
    }

    /** {@inheritDoc} */
    public void setHeight(int height) {
        this.height = height;
    }

    /** {@inheritDoc} */
    @Override
    public double getX() {
        return x;
    }

    /** {@inheritDoc} */
    @Override
    public void setX(double x) {
        this.x = x;
    }

    /** {@inheritDoc} */
    @Override
    public double getY() {
        return y;
    }

    /** {@inheritDoc} */
    @Override
    public void setY(double y) {
        this.y = y;
    }

    /** {@inheritDoc} */
    @Override
    public void draw(Graphics goon) {
        int intX = (int) x;
        int intY = (int) y;
        goon.setColor(new Color(186, 181, 169));
        goon.fillRect(intX, intY, width, height);

        // fill triangle
        goon.setColor(new Color(255, 255, 255));
        goon.fillPolygon(
            new int[]{intX, intX + (width / 2), intX + width},
            new int[]{intY, intY - (height / 2), intY},
            3
        );

        goon.drawImage(
            new ImageIcon("src/main/resources/images/rock.jpg").getImage(),
            intX + 5,
            intY + 5,
            width - 10,
            height - 10,
            null
        );

    }

}
