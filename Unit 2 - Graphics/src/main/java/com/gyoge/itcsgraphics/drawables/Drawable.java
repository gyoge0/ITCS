package com.gyoge.itcsgraphics.drawables;

import java.awt.Graphics;

@SuppressWarnings("unused")
public interface Drawable {

    int x = 0;
    int y = 0;

    void setX(int x);

    void setY(int y);

    int getX();

    int getY();

    void draw(Graphics goon);
}
