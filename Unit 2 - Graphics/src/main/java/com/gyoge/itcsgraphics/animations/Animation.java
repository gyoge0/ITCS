package com.gyoge.itcsgraphics.animations;

import com.gyoge.itcsgraphics.animators.Animator;

import java.util.HashMap;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Animation extends JPanel {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    protected BufferedImage bufferedImage;
    protected Graphics goon;
    protected String shownName = "Animation";
    /** List of animators for each object drawn. */
    protected Animator[] animators;
    /** Params with info for each animator. */
    protected HashMap<String, Object> params;


    /**
     * Start animation.
     */
    public Animation() {

        this.setUp();

        //set up and start the Timer
        Timer timer = new Timer(16, new TimerListener());
        timer.start();
    }

    /**
     * Set up animators. Should be overridden by subclasses.
     */
    protected void setUp() {
        // Should be overridden by subclasses
    }

    /**
     * Draw all objects in the animations.
     *
     * <p>
     * Should be overridden by subclasses.
     */
    protected void tick() {
        for (Animator animator : animators) {
            animator.getDrawable(params).draw(goon);
        }
    }

    /**
     * Timer for the animation.
     */
    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tick();
            repaint();
        }

    }

    protected void setShownName(String name) {
        this.shownName = name;
    }

    /** Getter for name. */
    public String getShownName() {
        return this.shownName;
    }


    /**
     * Paint the animation.
     *
     * @param goon The graphics object to draw on.
     */
    @Override
    public void paintComponent(Graphics goon) {
        goon.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
    }



}

