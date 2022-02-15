package com.gyoge.itcsgraphics.animations

import com.gyoge.itcsgraphics.animators.FalconNineAnimator
import java.awt.Color
import java.awt.Font
import java.awt.image.BufferedImage
import java.time.temporal.ChronoUnit

class FalconNine : Animation() {
    init {
        setUp()
        TimerListener().startTimer(FPS)
    }

    override fun setUp() {

        // Set up Buffered Image and Graphics objects
        bufferedImage = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
        goon = bufferedImage.graphics

        // Set name
        setShownName("Falcon 9")

        params = hashMapOf("HEIGHT" to HEIGHT, "WIDTH" to WIDTH)
        animators = listOf(
            FalconNineAnimator(
                WIDTH / 2, HEIGHT,
                50, 100,
                DT,
            )
        ).toTypedArray()

    }

    override fun tick() {
        val animator = animators[0] as FalconNineAnimator
        val drawable = animator.getDrawable(params)

        drawable.draw(goon)

        // Draw background
        goon.color = Color.BLACK
        goon.fillRect(0, 0, WIDTH, HEIGHT)

        // Draw average vlues
        goon.color = Color.WHITE
        goon.font = Font("Comic Sans MS", Font.BOLD, 16)
        goon.drawString("Delta time: ${(animators[0] as FalconNineAnimator).dT.toSeconds() * FPS} second(s)", 10, 30 + 10)

    }


    companion object {
        const val WIDTH = 800

        const val HEIGHT = 800

        const val FPS = 1

        val DT = ChronoUnit.MILLIS

        @JvmStatic
        fun main(args: Array<String>) {
            val animation: Animation = FalconNine()
            startUp(animation, LiftOff.WIDTH, LiftOff.HEIGHT)
        }

    }

}
