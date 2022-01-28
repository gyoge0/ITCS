package com.gyoge.itcsgraphics.animations;

import com.gyoge.itcsgraphics.animators.Animator;
import com.gyoge.itcsgraphics.animators.SnowflakeAnimator;
import com.gyoge.itcsgraphics.animators.SpaceshipAnimator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * LiftOff
 * <p>
 * An animation of a spaceship that flies up and down, with the illusion of speeding up via stars
 * speeding up in the background.
 *
 * @author Yogesh Thambidurai
 * @see Animator
 */
public class LiftOff extends Animation {


    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static final int FPS = 30;
    private static final Random random = new Random();

    public LiftOff() {

        this.setUp();

        new TimerListener().startTimer();
    }

    public static void main(String[] args) {
        Animation animation = new LiftOff();

        JFrame frame = new JFrame(
            String.format("Goon presents: %s by Yogesh Thambidurai", animation.getShownName())
        );

        frame.setSize(LiftOff.WIDTH, LiftOff.HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(animation);
    }

    @Override
    protected void setUp() {

        // set up Buffered Image and Graphics objects
        this.bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        goon = bufferedImage.getGraphics();

        //

        this.setShownName("Lift Off!");

        this.params = new HashMap<>();
        this.params.put("dx", 0);
        this.params.put("spaceshipDy", 1);
        this.params.put("snowflakeDy", 1);
        this.params.put("WIDTH", WIDTH);
        this.params.put("HEIGHT", HEIGHT);

        // Add in 100 snowflake animators
        ArrayList<Animator> animatorsAL = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            animatorsAL.add(new SnowflakeAnimator(
                random.nextInt(WIDTH),
                random.nextInt(HEIGHT),
                "dx",
                "snowflakeDy"
            ));
        }

        // Add in 1 spaceship animator
        animatorsAL.add(new SpaceshipAnimator(WIDTH / 2, 700, "spaceshipDy"));

        // set animators to the array value of animatorsAL
        this.animators = animatorsAL.toArray(new Animator[0]);

    }


    @Override
    protected void tick() {
        // Draw background
        goon.setColor(Color.BLACK);
        goon.fillRect(0, 0, WIDTH, HEIGHT);

        // Redraw all the animators
        for (Animator animator : animators) {
            animator.getDrawable(params).draw(goon);
        }

        // Accelerate the spaceship and snowflakes
        params.put("spaceshipDy", (int) Math.floor((int) params.get("spaceshipDy") - 0.05));
        params.put("snowflakeDy", (int) Math.ceil((int) params.get("snowflakeDy") + 0.05));
    }

}
