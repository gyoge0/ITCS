package com.gyoge.itcsgraphics.animators

import com.gyoge.itcsgraphics.drawables.Drawable
import com.gyoge.itcsgraphics.drawables.Ball
import java.awt.Color

/**
 * Animator for a bouncing ball.
 *
 * @see Animator
 * @see Ball
 */
class BouncingBallAnimator(
    private var xSpeed: Double = 1.0,
    private var ySpeed: Double = 1.0,
    /** X coordinate of the center of the ball. */
    x: Double = 0.0,
    /** Y coordinate of the center of the ball. */
    y: Double = 0.0,
    /** Diamter of the ball. */
    diameter: Double = 25.0,
    /** Color of the ball. */
    color: Color = Color.RED,
    /** Optional path to an image to be enscribed in the ball. */
    imagePath: String? = null
) : Animator {

    private val drawable: Ball

    init {
        drawable = Ball(x, y, diameter, color, imagePath)
    }

    override fun getDrawable(params: HashMap<String, Any>): Drawable {
        val x: Double = drawable.x
        val y: Double = drawable.y
        val radius: Double = drawable.radius

        drawable.x += xSpeed
        drawable.y += ySpeed

        if (x - radius < 0) {
            xSpeed *= -1
            drawable.x = 0 + radius
        }
        if (x + radius > (params["WIDTH"] as? Int ?: 400)) {
            xSpeed *= -1
            drawable.x = (params["WIDTH"] as? Int ?: 400).toDouble() - radius
        }
        if (y - radius < 0) {
            ySpeed *= -1
            drawable.y = 0 + radius
        }
        if (y + radius > (params["HEIGHT"] as? Int ?: 400)) {
            ySpeed *= -1
            drawable.y = (params["HEIGHT"] as? Int ?: 400).toDouble() - radius
        }


        return drawable
    }

}