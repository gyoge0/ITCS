package com.gyoge.itcsgraphics.animators

import com.gyoge.itcsgraphics.drawables.Ball
import com.gyoge.itcsgraphics.drawables.Drawable
import java.awt.Color
import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

@Suppress("unused")
class MouseKeyJumpingBall(
    /** X coordinate of the center of the ball. */
    x: Double = 0.0,
    /** Y coordinate of the center of the ball. */
    y: Double = 0.0,
    /** Diamter of the ball. */
    diameter: Double = 25.0,
    color: Color = Color.RED,
    /** Optional path to an image to be enscribed in the ball. */
    imagePath: String? = null,
) : Animator {

    private val drawable: Ball = Ball(x, y, diameter, color, imagePath)

    @Suppress("DuplicatedCode")
    override fun getDrawable(params: HashMap<String, Any>): Drawable {
        val diameter = this.drawable.diameter

        if (this.intersectsWith(params["ball"] as Ball)) {
            val width = (params["WIDTH"] as Int).toDouble()
            val height = (params["HEIGHT"] as Int).toDouble()

            this.drawable.x =
                random.nextDouble(width - diameter) + diameter / 2
            this.drawable.y =
                random.nextDouble(height - diameter) + diameter / 2

        }

        return this.drawable
    }

    private fun findDistanceFrom(x: Number, y: Number): Double {
        x as Double
        y as Double

        return sqrt((x - this.drawable.x).pow(2.0) + (y - this.drawable.y).pow(2.0))
    }

    private fun intersectsWith(ball: Ball): Boolean {
        return findDistanceFrom(
            ball.x,
            ball.y
        ) <= ball.diameter / 2.0 + this.drawable.diameter / 2.0
    }

    companion object {
        val random: Random = Random()
    }

}