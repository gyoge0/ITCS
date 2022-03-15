package com.gyoge.itcsgraphics.animations

import com.gyoge.itcsgraphics.animators.BouncingBallAnimator
import com.gyoge.itcsgraphics.animators.TeleportingBallAnimator
import com.gyoge.itcsgraphics.drawables.Ball
import java.awt.Color
import java.awt.Font
import java.awt.image.BufferedImage
import java.util.*

@Suppress("DuplicatedCode")
class JumpingBalls : Animation() {

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
        setShownName("Jumping Balls")
        params = HashMap()
        params["WIDTH"] = WIDTH
        params["HEIGHT"] = HEIGHT

        for (i in 1..BOUNCERS) {
            animators.add(
                BouncingBallAnimator(
                    25.0, 10.0,
                    random.nextDouble(WIDTH.toDouble()), random.nextDouble(HEIGHT.toDouble()),
                    250.0, Color.ORANGE
                )
            )
        }

        for (i in 1..JUMPERS) {
            animators.add(
                TeleportingBallAnimator(
                    WIDTH.toDouble() / 2 + i, HEIGHT.toDouble() / 2 + i, 150.0,
                    Color(random.nextInt(255 / i), random.nextInt(255 / i), random.nextInt(255 / i))
                )
            )
        }

        params["hits"] = 0
    }

    override fun tick() {
        // Draw background
        goon.color = Color.WHITE
        goon.fillRect(0, 0, WIDTH, HEIGHT)

        val balls = ArrayList<Ball>()
        for (i in 0 until BOUNCERS) {
            balls.add((animators[i] as BouncingBallAnimator).getDrawable(params) as Ball)
        }

        for (ball in balls) {
            ball.draw(goon)
        }

        for (i in BOUNCERS until animators.size) {
            val animator = (animators[i] as TeleportingBallAnimator)
            for (ball in balls) {
                params["ball"] = ball
                animator.getDrawable(params).draw(goon)
            }
        }

        goon.color = Color.BLACK
        goon.font = Font("Comic Sans MS", Font.BOLD, 16)

        goon.drawString("Hits: ${params["hits"]}", 10, 10 + 10)
    }


    /**
     * Companion object containing all the constants used
     */
    companion object {
        const val WIDTH = 800

        const val HEIGHT = 800

        /** Normally the FPS, but in this context becomes the DT. */
        const val FPS = 60

        const val BOUNCERS = 1
        const val JUMPERS = 5

        val random = Random()

        @JvmStatic
        fun main(args: Array<String>) {
            val animation: Animation = JumpingBalls()
            startUp(animation, LiftOff.WIDTH, LiftOff.HEIGHT)
        }

    }

}
