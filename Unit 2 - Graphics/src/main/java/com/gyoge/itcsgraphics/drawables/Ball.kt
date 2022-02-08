package com.gyoge.itcsgraphics.drawables

import java.awt.Color
import java.awt.Graphics
import javax.swing.ImageIcon
import kotlin.math.sqrt

/**
 * A ball that can be drawn on a canvas.
 *
 * @see Drawable
 * @see com.gyoge.itcsgraphics.animators.BouncingBallAnimator
 * @author Yogesh Thambidurai
 */
@Suppress(
    "unused",
    "MemberVisibilityCanBePrivate",
    "RemoveRedundantQualifierName"
)
class Ball constructor(
    /** X coordinate of the center of the ball. */
    var x: Double = 0.0,
    /** Y coordinate of the center of the ball. */
    var y: Double = 0.0,
    /** Diamter of the ball. */
    diameter: Double = 25.0,
    /** Color of the ball. */
    var color: Color = Color.RED,
    /** Optional path to an image to be enscribed in the ball. */
    val imagePath: String? = null
) : com.gyoge.itcsgraphics.drawables.Drawable {

    constructor(
        x: Int = 0,
        y: Int = 0,
        diameter: Int = 25,
        color: Color = Color.RED
    ) : this(
        x.toDouble(), y.toDouble(), diameter.toDouble(), color
    )

    /** Diameter for the ball. */
    var diameter: Double = diameter
        /** Private default setter to only be used by public custom setter. */
        @JvmName("innerSetDiameter")
        private set

    /** Radius for the ball. */
    var radius: Double = diameter / 2.0
        /** Private default setter to only be used by public custom setter. */
        @JvmName("innerSetRadius")
        private set

    /**
     * Setter for radius that ensures diamter is set at the same time.
     * @param radius Radius for the ball.
     */
    @JvmName("setRadius")
    fun setRadius(radius: Double) {
        this.radius = radius
        this.diameter = radius * 2.0
    }

    /**
     * Setter for diamter that ensures radius is set at the same time.
     * @param diameter Diameter for the ball.
     */
    @JvmName("setDiameter")
    fun setDiameter(diameter: Double) {
        this.diameter = diameter
        this.radius = diameter / 2.0
    }

    var xSpeed: Double = 0.0

    /** Dummy field for unit tests. */
    var ySpeed: Double = 0.0

    override fun draw(goon: Graphics) {
        goon.color = color
        goon.fillOval(
            (x - radius).toInt(),
            (y - radius).toInt(),
            diameter.toInt(),
            diameter.toInt()
        )

        if (imagePath != null) {
            goon.drawImage(
                ImageIcon(imagePath).image,
                // this is just trig to have the image match the dimensions of the square inscribed
                // in the circle.
                (x - ((radius * sqrt(2.0)) / 2.0)).toInt(),
                (y - ((radius * sqrt(2.0)) / 2.0)).toInt(),
                (radius * sqrt(2.0)).toInt(),
                (radius * sqrt(2.0)).toInt(),
                // literally who uses this
                null
            )
        }

    }

    /**
     * Set the center of the ball.
     *
     * @param x the x coordinate of the center of the ball
     * @param y the y coordinate of the center of the ball
     */
    fun setLocation(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    /**
     * Dummy method for unit tests.
     *
     * @param maxSpeed the maximum speed of the ball
     */
    fun setRandomSpeed(maxSpeed: Double) {
        xSpeed = Math.random() * maxSpeed
        ySpeed = Math.random() * maxSpeed
    }

}
