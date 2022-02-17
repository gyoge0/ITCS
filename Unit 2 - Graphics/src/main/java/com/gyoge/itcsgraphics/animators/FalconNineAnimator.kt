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
    /** Different masses. */
    private val masses: HashMap<Masses, Double> = defaultMasses
) : Animator {

    constructor(x: Int, y: Int, width: Int, height: Int, dT: Duration) : this(
        x,
        y,
        width,
        height,
        dT,
        defaultMasses
    )

    /** Enum containing keys for the masses hashmap. */
    enum class Masses {
        PHASE_1_STARTING,
        PHASE_1_ENDING,
        PHASE_1_FUEL,
        PHASE_1_THRUST,
        PHASE_2_STARTING,
        PHASE_2_ENDING,
        PHASE_2_FUEL,
        PHASE_2_THRUST,
    }

    val drawable = Spaceship()

    init {
        drawable.x = x.toDouble()
        drawable.y = y.toDouble()
        drawable.width = width
        drawable.height = height
    }


    /** Velocity of the spaceship. */
    var vel = 0.0

    /** Acceleration of the spaceship. */
    var accel = 0.0

    /** Altitude of the spaceship. */
    var alt = 0.0

    /** Time elapsed. */
    var time: Duration = Duration.ZERO

    /** Current mass of the rocket. */
    var mass: Double = 0.0

    /** Current net force acting on the object. */
    var netForce: Double = 0.0

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

        var thrust = 0.0
        var fuel = 0.0

        when (getStage()) {
            1 -> {
                val starting = masses[Masses.PHASE_1_STARTING] ?: 541300.0
                fuel = masses[Masses.PHASE_1_FUEL] ?: 398900.0
                thrust = masses[Masses.PHASE_1_THRUST] ?: 6806000.0
                mass = starting - (fuel / 162 * sec)
            }
            2 -> {
                val starting = masses[Masses.PHASE_2_STARTING] ?: 96570.0
                fuel = masses[Masses.PHASE_2_FUEL] ?: 92670.0
                thrust = masses[Masses.PHASE_2_THRUST] ?: 934000.0
                mass = starting - ((fuel / (397 - 162)) * (sec.toDouble() - 162))
            }
        }


        if (sec.toDouble() > 162) {
            mass = fuel - ((fuel / (397 - 162)) * (sec.toDouble() - 162))
        }

        val fG = mass * 6.67e-11 * 5.978e24 / ((6.38e6 + alt).pow(2.0))

        val fD = (0.5) * 0.295 * frontalArea * getDensity(alt) * vel.pow(2.0)

        netForce = thrust - fG - fD

        accel = netForce / mass
        vel += accel * dT.toNanos().toDouble() / 1e9
        alt += vel * dT.toNanos().toDouble() / 1e9

        time = time.plus(dT)

        drawable.y =
            params["HEIGHT"] as Int - alt * params["HEIGHT"] as Int / 300000.0 - drawable.height

        return drawable
    }


    private companion object {

        val defaultMasses: HashMap<Masses, Double> = hashMapOf(
            Masses.PHASE_1_STARTING to 541300.0,
            Masses.PHASE_1_ENDING to 142400.0,
            Masses.PHASE_1_FUEL to 398900.0,
            Masses.PHASE_1_THRUST to 6806000.0,
            Masses.PHASE_2_STARTING to 96570.0,
            Masses.PHASE_2_ENDING to 3900.0,
            Masses.PHASE_2_FUEL to 92670.0,
            Masses.PHASE_2_FUEL to 934000.0,
        )

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
