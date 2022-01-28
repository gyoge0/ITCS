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

public class LiftOff extends Animation {


    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private static final Random random = new Random();

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

        //set up Buffered Image and Graphics objects
        this.bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        goon = bufferedImage.getGraphics();

        ArrayList<Animator> animatorsAL = new ArrayList<>();

        this.setShownName("Lift Off!");

        this.params = new HashMap<>();
        this.params.put("dx", 0);
        this.params.put("dy", 0);
        this.params.put("WIDTH", WIDTH);

        for (int i = 0; i < 100; i++) {
            animatorsAL.add(new SnowflakeAnimator(random.nextInt(WIDTH), random.nextInt(HEIGHT)));
        }

        animatorsAL.add(new SpaceshipAnimator(WIDTH/2, 700));

        // set animators to the array value of animatorsAL
        this.animators = animatorsAL.toArray(new Animator[0]);

    }


    @Override
    protected void tick() {
        goon.setColor(Color.BLACK);
        goon.fillRect(0, 0, WIDTH, HEIGHT);

        for (Animator animator : animators) {
            animator.getDrawable(params).draw(goon);
        }

        params.put("dy", (int) params.get("dy") + 1);
    }

}
