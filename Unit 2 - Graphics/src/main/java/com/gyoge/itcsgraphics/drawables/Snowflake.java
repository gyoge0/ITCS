package com.gyoge.itcsgraphics.drawables;

import java.awt.*;

import java.util.Random;

public class Snowflake implements Drawable {

    private int x;
    private int y;
    private static final Random random = new Random();

    public Snowflake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @SuppressWarnings("DuplicatedCode")
    public void draw(Graphics goon) {
        int color = random.nextInt(55) + 200;
        goon.setColor(new Color(color, color, color));

        goon.drawLine(x - 3, y, x + 3, y);
        goon.drawLine(x, y - 3, x, y + 3);
        goon.drawLine(x - 3, y - 3, x + 3, y + 3);
        goon.drawLine(x + 3, y - 3, x - 3, y + 3);

        goon.drawPolygon(new Polygon(
            new int[]{x - 2, x + 2, x, x, x - 2, x + 2, x - 2, x - 2},
            new int[]{y, y, y - 2, y + 2, y - 2, y + 2, y + 2, y - 2},
            8
        ));
    }

}
