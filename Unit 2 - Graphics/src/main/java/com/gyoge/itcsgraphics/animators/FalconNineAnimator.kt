package com.gyoge.itcsgraphics.animators

import com.gyoge.itcsgraphics.drawables.Drawable
import com.gyoge.itcsgraphics.drawables.Spaceship
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.Duration
import java.time.temporal.ChronoUnit

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
    dT: ChronoUnit = ChronoUnit.SECONDS,
) : Animator {

    val drawable = Spaceship()

    init {
        drawable.x = x.toDouble()
        drawable.y = y.toDouble()
        drawable.width = width
        drawable.height = height
    }

    /** Mass of the spaceship. */
    var mass = BigDecimal("541300")

    /** Velocity of the spaceship. */
    private var vel = BigDecimal("0")

    /** Acceleration of the spaceship. */
    private var accel = BigDecimal("0")

    /** Altitude of the spaceship. */
    var alt = BigDecimal("0")

    private var time = Duration.ZERO

    /** Change in time for each frame. */
    val dT: Duration = dT.duration

    /** Assuming the frontal area is the width squared of the spaceship. */
    private val frontalArea = BigDecimal(drawable.width).pow(2)

    override fun getDrawable(params: HashMap<String, Any>): Drawable {
        if (time.seconds > 162) {
            return drawable
        }
        mass = mass.minus(FUEL_BURN_RATE.multiply(BigDecimal(dT.seconds)))

        val fG = -calcFg()
        val fT = THRUST
        // TODO: drag broken
//        val fD = vel
//            .pow(2)
//            .multiply(DRAG_COEFFICIENT)
//            .multiply(frontalArea)
//            .multiply(closestDensity(alt))
//            .divide(BigDecimal(2), 5, RoundingMode.UP)
//            .multiply(BigDecimal(-1))
//        accel = calcAccel(fG, fT, fD)

        accel = calcAccel(fG, fT)
        vel = vel.add(accel)
        alt = alt.add(vel)
        println(drawable.y)

        params["HEIGHT"] as Int + drawable.height - alt.toDouble()

        time = time.plus(dT)

        return drawable
    }


    /** Calculates force due to gravity using the Earth, the mass of the spaceship, and the altitude. */
    private fun calcFg(): BigDecimal = calcFg(MASS_EARTH, mass, RAD_EARTH + alt)

    /** Calculate acceleration from a list of forces. */
    private fun calcAccel(vararg forces: BigDecimal): BigDecimal {
        var sum = BigDecimal("0")
        for (force in forces) {
            sum = sum.plus(force)
        }
        return sum
    }

    private companion object {
        /** Mass of the Earth. */
        val MASS_EARTH = BigDecimal("5.978e24")

        /** Gravitational constant. */
        private val BIG_G = BigDecimal("6.67e-11")

        /** Radius of the Earth. */
        val RAD_EARTH = BigDecimal("6.38e6")

        /** Kg of fuel burned per second. */
        val FUEL_BURN_RATE: BigDecimal = BigDecimal("398900").divide(BigDecimal("162"), 5, RoundingMode.UP)

        /** Force due to thrust. */
        val THRUST = BigDecimal("6806000")

        /** Densities at different altitues from the US Standard Atmosphere Air Properties. */
        private val DENSITIES = hashMapOf(
            BigDecimal("1000") to BigDecimal(1.112),
            BigDecimal("2000") to BigDecimal(1.007),
            BigDecimal("3000") to BigDecimal(0.9093),
            BigDecimal("4000") to BigDecimal(0.8194),
            BigDecimal("5000") to BigDecimal(0.7364),
            BigDecimal("6000") to BigDecimal(0.6601),
            BigDecimal("7000") to BigDecimal(0.5900),
            BigDecimal("8000") to BigDecimal(0.5258),
            BigDecimal("9000") to BigDecimal(0.4671),
            BigDecimal("10000") to BigDecimal(0.4135),
            BigDecimal("15000") to BigDecimal(0.1948),
            BigDecimal("20000") to BigDecimal(0.08891),
            BigDecimal("25000") to BigDecimal(0.04008),
            BigDecimal("30000") to BigDecimal(0.01841),
            BigDecimal("40000") to BigDecimal(0.003996),
            BigDecimal("50000") to BigDecimal(0.001027),
            BigDecimal("60000") to BigDecimal(0.0003097),
            BigDecimal("70000") to BigDecimal(0.00008283),
            BigDecimal("80000") to BigDecimal(0.00001846),
        )

        /**
         * Drag coefficient from <a href="https://www.grc.nasa.gov/www/k-12/rocket/shaped.html">NASA</a>.
         * 0.295 (from the bullet) is used because it is most similar here to the actual Falcon 9.
         * The value can be swapped to something more accurate to the actual Falcon 9 or to the
         * pyramid used in the drawing.
         */
        val DRAG_COEFFICIENT = BigDecimal("0.295")

        /**
         * Binary searches densities to find the closest density for a given altitude.
         */
        @JvmStatic
        fun closestDensity(alt: BigDecimal): BigDecimal {
            val keys = DENSITIES.keys.sorted()
            var min = 0
            var max: Int = keys.size - 1
            var mid = 0

            while(min <= max) {
                mid = ((max + min) / 2)
                if (keys[mid] == alt) {
                    return DENSITIES[alt]!!
                } else if (keys[mid] < alt) {
                    min = mid + 1
                } else {
                    max = mid - 1
                }
            }

            return DENSITIES[keys[mid]] ?: BigDecimal.ZERO

        }

        /** Calculates gravitational force between 2 masses some distance apart. */
        @JvmStatic
        fun calcFg(mass1: BigDecimal, mass2: BigDecimal, distance: BigDecimal): BigDecimal {
            println((mass1.toDouble() * mass2.toDouble() * BIG_G.toDouble())/(distance.toDouble() * distance.toDouble()))
            println((mass1.multiply(mass2).multiply(BIG_G)).divide(distance.pow(2), 5, RoundingMode.UP))
            return mass1.multiply(mass2).multiply(BIG_G).divide(distance.pow(2), 5, RoundingMode.UP)
        }

    }
}