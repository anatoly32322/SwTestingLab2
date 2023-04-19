package project.logarithms

import kotlin.math.pow

class Log {

    fun calc(x: Double, y: Double, eps: Double = 10.0.pow(-9.0)): Double {
        if (y == 1.0)
            return Double.NaN
        val ans = Ln().calc(x, eps) / Ln().calc(y, eps)
        return ans
    }
}