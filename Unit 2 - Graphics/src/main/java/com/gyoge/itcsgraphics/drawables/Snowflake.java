package com.gyoge.itcsgraphics.drawables;

import java.util.Random;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * A simple snowflake.
 *
 * @author Yogesh Thambidurai
 * @see com.gyoge.itcsgraphics.animators.SnowflakeAnimator
 */
public class Snowflake implements Drawable {

    private static final Random random = new Random();
    private double x;
    private double y;

    public Snowflake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @SuppressWarnings("DuplicatedCode")
    public void draw(Graphics goon) {
        int intX = (int) this.x;
        int intY = (int) this.y;
        int color = random.nextInt(55) + 200;
        goon.setColor(new Color(color, color, color));

        goon.drawLine(intX - 3, intY, intX + 3, intY);
        goon.drawLine(intX, intY - 3, intX, intY + 3);
        goon.drawLine(intX - 3, intY - 3, intX + 3, intY + 3);
        goon.drawLine(intX + 3, intY - 3, intX - 3, intY + 3);

        goon.drawPolygon(new Polygon(
            new int[]{intX - 2, intX + 2, intX, intX, intX - 2, intX + 2, intX - 2, intX - 2},
            new int[]{intY, intY, intY - 2, intY + 2, intY - 2, intY + 2, intY + 2, intY - 2},
            8
        ));
    }

}
