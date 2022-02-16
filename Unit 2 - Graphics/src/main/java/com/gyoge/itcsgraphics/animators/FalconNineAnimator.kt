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

    /** Do the math and then update the drawable. */
    override fun getDrawable(params: HashMap<String, Any>): Drawable {
        val sec = (time.seconds)

        if (sec.toDouble() > 162) {
            return drawable
        }

        val mass = START_MASS - (FUEL_BURN_RATE * (sec))

        val fG = mass * BIG_G * MASS_EARTH / ((RAD_EARTH + alt).pow(2.0))

        val fD = (0.5) * DRAG_COEFFICIENT * frontalArea * getDensity(alt) * vel.pow(2.0)

        val net = THRUST - fG - fD

        accel = net / mass
        vel += accel * dT.toNanos().toDouble() / 1e9
        alt += vel * dT.toNanos().toDouble() / 1e9

        time += dT

        drawable.y = alt * 100000 / (params["HEIGHT"] as Int)

        return drawable
    }


    /** Calculates force due to gravity using the Earth, the mass of the spaceship, and the altitude. */
    private fun calcFg(): Double =
        calcFg(
            MASS_EARTH,
            START_MASS - (FUEL_BURN_RATE * time.seconds),
            RAD_EARTH + alt
        )

    private companion object {
        /** Mass of the Earth. */
        const val MASS_EARTH = 5.978e24

        /** Starting mass of the spaceship. */
        var START_MASS = 541300

        /** Gravitational constant. */
        private const val BIG_G = 6.67e-11

        /** Radius of the Earth. */
        const val RAD_EARTH = 6.38e6

        /** Kg of fuel burned per second. */
        const val FUEL_BURN_RATE: Double = 398900.0 / 162.0

        /** Force due to thrust. */
        const val THRUST = 6806000

        /**
         * Drag coefficient from <a href="https://www.grc.nasa.gov/www/k-12/rocket/shaped.html">NASA</a>.
         * 0.295 (from the bullet) is used because it is most similar here to the actual Falcon 9.
         * The value can be swapped to something more accurate to the actual Falcon 9 or to the
         * pyramid used in the drawing.
         */
        const val DRAG_COEFFICIENT = 0.295

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

        /** Calculates gravitational force between 2 masses some distance apart. */
        @JvmStatic
        fun calcFg(mass1: Double, mass2: Double, distance: Double): Double {
            return mass1 * (mass2) * (BIG_G) / distance.pow(2.0)
        }

    }
}