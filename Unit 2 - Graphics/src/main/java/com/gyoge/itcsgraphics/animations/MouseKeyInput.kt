package com.gyoge.itcsgraphics.animations

import com.gyoge.itcsgraphics.animators.BouncingBallAnimator
import com.gyoge.itcsgraphics.animators.MouseKeyJumpingBall
import java.awt.Color
import java.awt.Font
import java.awt.event.*
import java.awt.image.BufferedImage
import java.util.*

@Suppress("DuplicatedCode")
class MouseKeyInput : Animation() {

    /**
     * Constructor to start the animation.
     */
    init {
        setUp()
        TimerListener().startTimer(FPS)
    }

    private var color: Color = Color.BLACK

    override fun setUp() {

        // Set up Buffered Image and Graphics objects
        bufferedImage = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
        goon = bufferedImage.graphics

        // Set name
        setShownName("MouseActions Key Input")
        params = HashMap()
        params["WIDTH"] = WIDTH
        params["HEIGHT"] = HEIGHT

        animators.add(
            BouncingBallAnimator(
                25.0, 10.0,
                random.nextDouble(WIDTH.toDouble()), random.nextDouble(HEIGHT.toDouble()),
                250.0,
                Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))
            )
        )

        animators.add(
            MouseKeyJumpingBall(
                WIDTH.toDouble() / 2, HEIGHT.toDouble() / 2, 150.0,
                Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))
            )
        )

        this.addMouseListener(MouseActions())
        this.addMouseWheelListener(MouseWheelActions())
        this.addKeyListener(KeyActions())

    }

    override fun tick() {
        this.requestFocus()
        // Draw background
        goon.color = this.color
        goon.fillRect(0, 0, WIDTH, HEIGHT)
        val ball = animators[0].getDrawable(params)
        params["ball"] = ball
        animators[1].getDrawable(params).draw(goon)
        ball.draw(goon)

        goon.color = Color.BLACK
        goon.font = Font("Comic Sans MS", Font.BOLD, 16)

        goon.drawString("Hits: ${params["hits"]}", 10, 10 + 10)
    }

    private inner class MouseActions : MouseListener {
        override fun mouseClicked(e: MouseEvent?) {
            // Not implemented
        }

        override fun mousePressed(e: MouseEvent?) {
            when (e?.button) {
                // Left click
                MouseEvent.BUTTON1 -> {
                    color = Color.ORANGE
                }
                // Right click
                MouseEvent.BUTTON3 -> {
                    color = Color.BLUE
                }
                // Middle click
                MouseEvent.BUTTON2 -> {
                    color = Color.GREEN
                }
            }
        }

        override fun mouseReleased(e: MouseEvent?) {
            // Not implemented
        }

        override fun mouseEntered(e: MouseEvent?) {
            color = Color.RED
        }

        override fun mouseExited(e: MouseEvent?) {
            color = Color.WHITE
        }
    }

    private inner class MouseWheelActions : MouseWheelListener {
        override fun mouseWheelMoved(e: MouseWheelEvent?) {
            when (e?.wheelRotation) {
                // Scroll up
                1 -> {
                    color = Color.CYAN
                }
                // Scroll down
                -1 -> {
                    color = Color.DARK_GRAY
                }
            }
        }
    }

    private inner class KeyActions : KeyListener {
        override fun keyTyped(e: KeyEvent?) {
            // Not implemented
        }

        override fun keyPressed(e: KeyEvent?) {
            when (e?.keyChar) {
                'a' -> {
                    color = Color.MAGENTA
                }
                'b' -> {
                    color = Color.YELLOW
                }
                'c' -> {
                    color = Color.PINK
                }
                'd' -> {
                    color = Color.LIGHT_GRAY
                }
            }
        }

        override fun keyReleased(e: KeyEvent?) {
            // Not implemented
        }
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
            val animation: Animation = MouseKeyInput()
            startUp(animation, LiftOff.WIDTH, LiftOff.HEIGHT)
        }

    }

}
