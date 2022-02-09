package com.gyoge.itcsgraphics.animations

import com.gyoge.itcsgraphics.animators.Animator
import com.gyoge.itcsgraphics.animators.BouncingBallAnimator
import java.awt.Color
import java.awt.image.BufferedImage
import java.util.Random

/**
 * A bunch of bouncing balls.
 *
 *
 * @author Yogesh Thambidurai
 * @see Animation
 * @see com.gyoge.itcsgraphics.drawables.Ball
 * @see BouncingBallAnimator
 */
class BouncingBalls : Animation() {
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
        setShownName("Bouncing Balls")
        params = HashMap()
        params["WIDTH"] = WIDTH
        params["HEIGHT"] = HEIGHT

        // Add in 100 bouncing balls
        val animatorsAL = ArrayList<Animator>()
        for (i in 0..100) {
            animatorsAL.add(
                BouncingBallAnimator(
                    (random.nextDouble(25.0) + 0.01) - 12.5,
                    (random.nextDouble(25.0) + 0.01) - 12.5,
                    400.0,
                    400.0,
                    100.0,
                    Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
                    "src/main/resources/images/rock.jpg"
                )
            )
        }


        // Set animators to the array value of animatorsAL for speed
        animators = animatorsAL.toTypedArray()
    }

    override fun tick() {
        // Draw background
        goon.color = Color.BLACK
        goon.fillRect(0, 0, WIDTH, HEIGHT)

        super.tick()
    }


    /**
     * Companion object containing all the constants used
     */
    companion object {
        const val WIDTH = 800

        const val HEIGHT = 800

        const val FPS = 60

        val random = Random()

        @JvmStatic
        fun main(args: Array<String>) {
            val animation: Animation = BouncingBalls()
            startUp(animation, LiftOff.WIDTH, LiftOff.HEIGHT)
        }

    }

}

