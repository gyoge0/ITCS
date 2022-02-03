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

/**
 * Animation
 * <p>
 * A superclass for all animations to inherit from. Provides methods to partially set up the
 * animation, but requires overriding of some methods.
 *
 * @author Yogesh Thambidurai
 */
public class Animation extends JPanel {

    /** Width for animations. Can be overridden. */
    @SuppressWarnings("unused")
    public static final int WIDTH = 400;
    /** Height for animations. Can be overridden. */
    @SuppressWarnings("unused")
    public static final int HEIGHT = 400;
    /** FPS/Tick rate for animations. Can be overridden. */
    @SuppressWarnings("unused")
    protected static final int FPS = 60;
    /** BufferedImage to draw objects on. */
    protected BufferedImage bufferedImage;
    /** Graphics object to draw objects with. */
    protected Graphics goon;
    /** Default name shown in title bar. */
    protected String shownName = "An Animation";
    /** List of animators for each object drawn. */
    protected Animator[] animators;
    /** Params with info for each animator. */
    protected HashMap<String, Object> params;

    /**
     * A method to quickly start up an animation.
     *
     * @param animation The animation to run.
     * @param width     The default width of the animation.
     * @param height    The default height of the animation.
     */
    public static void startUp(Animation animation, int width, int height) {
        JFrame frame = new JFrame(
            String.format("Goon presents: %s by Yogesh Thambidurai", animation.getShownName())
        );

        frame.setSize(width, height);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(animation);
    }

    /**
     * Set up animators.
     *
     * <p>
     * Should be overridden by subclasses.
     *
     * @see Animator
     */
    protected void setUp() {
        // Should be overridden by subclasses
    }

    /**
     * Draw all objects in the animations.
     *
     * <p>
     * Should be overridden by subclasses.
     *
     * @see Animator
     */
    protected void tick() {
        for (Animator animator : animators) {
            animator.getDrawable(params).draw(goon);
        }
    }

    /**
     * Getter for name.
     *
     * @return The name.
     */
    public String getShownName() {
        return this.shownName;
    }

    /**
     * Set name. Mostly used in setUp() boilerplate.
     *
     * @param name The value to set name to.
     */
    @SuppressWarnings("SameParameterValue")
    protected void setShownName(String name) {
        this.shownName = name;
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

    /**
     * Timer for the animation.
     */
    protected class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tick();
            repaint();
        }

        /**
         * Start the timer at the fps specified.
         *
         * @param fps The fps/tick rate.
         */
        public void startTimer(int fps) {
            Timer timer = new Timer(1000 / fps, this);
            timer.start();
        }

    }

}

