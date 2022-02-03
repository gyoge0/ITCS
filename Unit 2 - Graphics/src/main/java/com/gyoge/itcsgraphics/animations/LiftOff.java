package com.gyoge.itcsgraphics.animations;

import com.gyoge.itcsgraphics.animators.Animator;
import com.gyoge.itcsgraphics.animators.SnowflakeAnimator;
import com.gyoge.itcsgraphics.animators.SpaceshipAnimator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * A spaceship that flies up and down over a backdrop of stars.
 *
 * <p>
 * Yes, the stars are reused snowflakes.
 *
 * @author Yogesh Thambidurai
 * @see Animation
 * @see com.gyoge.itcsgraphics.drawables.Snowflake
 * @see SnowflakeAnimator
 * @see com.gyoge.itcsgraphics.drawables.Spaceship
 * @see SpaceshipAnimator
 */
public class LiftOff extends Animation {


    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static final int FPS = 30;
    private static final Random random = new Random();

    public LiftOff() {

        this.setUp();

        new TimerListener().startTimer(FPS);
    }

    public static void main(String[] args) {
        Animation animation = new LiftOff();

        Animation.startUp(animation, WIDTH, HEIGHT);
    }

    @Override
    protected void setUp() {

        // Set up Buffered Image and Graphics objects
        this.bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        goon = bufferedImage.getGraphics();

        // Set name
        this.setShownName("Lift Off!");

        this.params = new HashMap<>();
        this.params.put("spaceshipDy", 1.0);
        this.params.put("snowflakeDy", 1.0);
        this.params.put("spaceshipDx", 0.0);
        this.params.put("snowflakeDx", 0.0);
        this.params.put("WIDTH", WIDTH);
        this.params.put("HEIGHT", HEIGHT);

        // Add in 100 snowflake animators
        ArrayList<Animator> animatorsAL = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            animatorsAL.add(new SnowflakeAnimator(
                random.nextInt(WIDTH),
                random.nextInt(HEIGHT),
                "snowflakeDx",
                "snowflakeDy"
            ));
        }

        // Add in 1 spaceship animator
        animatorsAL.add(new SpaceshipAnimator(WIDTH / 2, 700, "spaceshipDy"));

        // Set animators to the array value of animatorsAL for speed
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
        params.put("spaceshipDy", (double) params.get("spaceshipDy") - 0.05);
        params.put("snowflakeDy", (double) params.get("snowflakeDy") + 0.05);
    }

}
