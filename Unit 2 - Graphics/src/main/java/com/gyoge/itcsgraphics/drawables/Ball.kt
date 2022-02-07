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

    /** Diameter for the ball. */
    var diameter: Double = diameter
        /** Custom setter to ensure radius is accurate. */
        set(value) {
            // If recursive setting is false, then we are setting diameter. Set the diameter, set
            // recursive setting to true, set the radius, and then set recursive setting back to
            // false.
            if (!recursiveSetting) {
                field = value
                recursiveSetting = true
                radius = value / 2.0
                recursiveSetting = false
            }
            // If recursive setting is true, then we are setting radius. Set the diameter and don't
            // recurse the radius call.
            else {
                field = value
            }
        }

    /** Radius for the ball. */
    var radius: Double = diameter / 2.0
        /** Custom setter to ensure diameter is accurate. */
        set(value) {
            // If recursive setting is false, then we are setting radius. Set the radius, set
            // recursive setting to true, set the diameter, and then set recursive setting back to
            // false.
            if (!recursiveSetting) {
                field = value
                recursiveSetting = true
                diameter = value * 2.0
                recursiveSetting = false
            }
            // If recursive setting is true, then we are setting diameter. Set the radius and don't
            // recurse the diameter call.
            else {
                field = value
            }
        }

    /**
     * Hack to prevent recursive setting of diameter and radius.
     */
    private var recursiveSetting: Boolean = false

    /** Dummy field for unit tests. */
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
