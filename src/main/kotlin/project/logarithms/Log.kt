package project.logarithms

import kotlin.math.pow

class Log : LogarithmsInterface {

    override fun calc(x: Double, base: Double, eps: Double): Double {
        if (base == 1.0)
            return Double.NaN
        val ans = Ln().calc(x, eps) / Ln().calc(base, eps)
        return ans
    }
}