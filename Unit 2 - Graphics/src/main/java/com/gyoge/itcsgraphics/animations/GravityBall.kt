package com.gyoge.itcsgraphics.animations

import com.gyoge.itcsgraphics.animators.Animator
import com.gyoge.itcsgraphics.animators.GravityBallAnimator
import java.awt.Color
import java.awt.Font
import java.awt.image.BufferedImage
import java.util.Random

class GravityBall : Animation() {
    /**
     * Constructor to start the animation.
     */
    init {
        setUp()
        TimerListener().startTimer(FPS)
    }

    override fun setUp() {

        // Set up Buffered Image and Graphics objects
        bufferedImage = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
        goon = bufferedImage.graphics

        // Set name
        setShownName("Gravity Ball")
        params = HashMap()
        params["WIDTH"] = WIDTH
        params["HEIGHT"] = HEIGHT
        params["DT"] = FPS.toDouble()

        val animatorsAL = ArrayList<Animator>()

        for (i in 1..100) {
            val animator = GravityBallAnimator(
                0.0,
                -9.8,
                (WIDTH / 2).toDouble(),
                (HEIGHT / 2).toDouble(),
                random.nextDouble(1.0),
                Color(
                    random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255)
                ),
            )
            animator.setInitialVelocity(random.nextInt(16, 256), random.nextInt(360))

            animatorsAL.add(animator)
        }

        // Set animators to the array value of animatorsAL for speed
        animators = animatorsAL.toTypedArray()
    }

    override fun tick() {
        // Draw background
        goon.color = Color.WHITE
        goon.fillRect(0, 0, WIDTH, HEIGHT)

        // For getting average values
        var sumXVel = 0.0
        var sumYVel = 0.0
        var sumElasticity = 0.0

        // Get values and draw
        for (animator in animators) {
            animator as GravityBallAnimator

            animator.getDrawable(params).draw(goon)

            sumXVel += animator.xSpeed
            sumYVel += animator.ySpeed
            sumElasticity += animator.elasticity
        }

        // Draw average vlues
        goon.color = Color.BLACK
        goon.font = Font("Comic Sans MS", Font.BOLD, 16)

        goon.drawString("Number of balls: ${animators.size}", 10, 10 + 10)
        goon.drawString("FPS: $FPS", 10, 30 + 10)
        goon.drawString("Average X Velocity: ${sumXVel / animators.size}", 10, 50 + 10)
        goon.drawString("Average Y Velocity: ${sumYVel / animators.size}", 10, 70 + 10)
        goon.drawString("Average Elasticity: ${sumElasticity / animators.size}", 10, 90 + 10)

    }


    /**
     * Companion object containing all the constants used
     */
    companion object {
        const val WIDTH = 800

        const val HEIGHT = 800

        /** Normally the FPS, but in this context becomes the DT. */
        const val FPS = 60

        val random = Random()

        @JvmStatic
        fun main(args: Array<String>) {
            val animation: Animation = GravityBall()
            startUp(animation, LiftOff.WIDTH, LiftOff.HEIGHT)
        }

    }

}