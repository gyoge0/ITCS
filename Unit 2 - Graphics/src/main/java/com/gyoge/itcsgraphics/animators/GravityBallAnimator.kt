package com.gyoge.itcsgraphics.animators

import com.gyoge.itcsgraphics.drawables.Ball
import com.gyoge.itcsgraphics.drawables.Drawable
import java.awt.Color
import kotlin.math.cos
import kotlin.math.sin

@Suppress("unused")
class GravityBallAnimator(
    /** Current X Velocity of the ball */
    var xSpeed: Double = 1.0,
    /** Current Y Velocity of the ball */
    var ySpeed: Double = 1.0,
    private var xAcceleration: Double = 0.0,
    private var yAcceleration: Double = 0.0,
    /** X coordinate of the center of the ball. */
    x: Double = 0.0,
    /** Y coordinate of the center of the ball. */
    y: Double = 0.0,
    /** Diamter of the ball. */
    diameter: Double = 25.0,
    /** Energy loss */
    val elasticity: Double = 1.0,
    /** Color of the ball. */
    color: Color = Color.RED,
    /** Optional path to an image to be enscribed in the ball. */
    imagePath: String? = null,
    /** String used to identify dt */
    private val dtIdentifier: String = "DT"
) : Animator {

    constructor(x: Int, y: Int, diameter: Double, color: Color) :
            this(1.0, 1.0, 0.0, 0.0, x.toDouble(), y.toDouble(), diameter, 1.0, color)

    constructor(
        xAcceleration: Double,
        yAcceleration: Double,
        x: Double,
        y: Double,
        elasticity: Double,
        color: Color
    ) :
            this(0.0, 0.0, xAcceleration, yAcceleration, x, y, 25.0, elasticity, color)

    fun setInitialVelocity(speed: Int, angle: Int) {
        xSpeed = speed * cos(Math.toRadians(angle.toDouble()))
        ySpeed = speed * sin(Math.toRadians(angle.toDouble()))
    }

    private val drawable: Ball


    init {
        drawable = Ball(x, y, diameter, color, imagePath)
    }

    @Suppress("DuplicatedCode")
    override fun getDrawable(params: HashMap<String, Any>): Drawable {
        val dt = 1 / params[dtIdentifier] as Double
        ySpeed += yAcceleration
        xSpeed += xAcceleration

        drawable.x += xSpeed * dt
        drawable.y -= ySpeed * dt

        val x: Double = drawable.x
        val y: Double = drawable.y
        val radius: Double = drawable.radius

        if (x - radius < 0) {
            xSpeed *= -elasticity
            drawable.x = 0 + radius
        }
        if (x + radius > (params["WIDTH"] as? Int ?: 400)) {
            xSpeed *= -elasticity
            drawable.x = (params["WIDTH"] as? Int ?: 400).toDouble() - radius
        }
        if (y - radius < 0) {
            ySpeed *= -elasticity
            drawable.y = 0 + radius
        }
        if (y + radius > (params["HEIGHT"] as? Int ?: 400)) {
            ySpeed *= -elasticity
            drawable.y = (params["HEIGHT"] as? Int ?: 400).toDouble() - radius
        }

        return drawable
    }

    @Deprecated("Use getDrawable(params: HashMap<String, Any>) instead.")
    fun launch(rightEdge: Int, bottomEdge: Int, deltaTime: Double): Drawable {
        return getDrawable(
            hashMapOf(
                "WDITH" to rightEdge,
                "HEIGHT" to bottomEdge,
                dtIdentifier to deltaTime
            )
        )
    }


}