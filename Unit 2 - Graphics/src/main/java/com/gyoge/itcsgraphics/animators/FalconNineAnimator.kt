package com.gyoge.itcsgraphics.animators

import com.gyoge.itcsgraphics.drawables.Drawable
import com.gyoge.itcsgraphics.drawables.Spaceship
import java.time.Duration
import java.time.temporal.ChronoUnit
import kotlin.math.pow

/**
 * A laws-of-physics-obeying animator a spaceship.
 *
 * This animator will have the spaceship follow a launch similar to that of the Falcon 9.
 *
 * @author Yogesh Thambidurai
 * @see Spaceship
 * @see Animator
 */
@Suppress("unused", "UNUSED_VARIABLE")
class FalconNineAnimator(
    x: Int = 0,
    y: Int = 0,
    width: Int = 50,
    height: Int = 100,
    /** Change in time for each frame. */
    private val dT: Duration = ChronoUnit.SECONDS.duration,
) : Animator {

    val drawable = Spaceship()

    init {
        drawable.x = x.toDouble()
        drawable.y = y.toDouble()
        drawable.width = width
        drawable.height = height
    }


    /** Velocity of the spaceship. */
    private var vel = 0.0

    /** Acceleration of the spaceship. */
    private var accel = 0.0

    /** Altitude of the spaceship. */
    var alt = 0.0

    /** Time elapsed. */
    var time: Duration = Duration.ZERO

    /** Assuming the frontal area is the width squared of the spaceship. */
    private val frontalArea = drawable.width.toDouble().pow(2.0)

    fun getStage(): Int {
        // return 2 if time.seconds is greater than 162, otherwise return 1
        return if (time.seconds > 162) 2 else 1

    }

    /** Do the math and then update the drawable. */
    override fun getDrawable(params: HashMap<String, Any>): Drawable {
        val sec = (time.seconds)
        if (time.seconds > 397) {
            return drawable
        }

        var mass: Double = 541300 - (398900 / 162 * (sec)).toDouble()
        var thrust = 6806000.0

        if (sec.toDouble() > 162) {
            mass = 96570 - ((92670 / (397 - 162)) * (sec.toDouble() - 162))
            thrust = 934000.0
        }

        val fG = mass * 6.67e-11 * 5.978e24 / ((6.38e6 + alt).pow(2.0))

        val fD = (0.5) * 0.295 * frontalArea * getDensity(alt) * vel.pow(2.0)

        val net = thrust - fG - fD

        accel = net / mass
        vel += accel * dT.toNanos().toDouble() / 1e9
        alt += vel * dT.toNanos().toDouble() / 1e9

        time = time.plus(dT)

        drawable.y = (alt * 100000 / (params["HEIGHT"] as Int)) - drawable.height

        return drawable
    }


    private companion object {

        /**
         * Calculates the air density at a given altitude.
         *
         * Calculated using an Ae^Bx regression, whose coefficients were obtained from Coseen.
         *
         * A = 1.2787, B = -0.0018
         *
         * @author Coseen
         */
        fun getDensity(alt: Double): Double {
            return 1.2787 * Math.E.pow(-0.000114616 * alt)
        }

    }
}