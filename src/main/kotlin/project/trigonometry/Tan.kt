package project.trigonometry

import kotlin.math.abs
import kotlin.math.pow

class Tan {
    fun calc(x: Double, eps: Double = 10.0.pow(-9.0)): Double {
        val cs = Cos().calc(x, eps)
        if (abs(cs) < 1e-9)
            return Double.NaN
        val ans = Sin().calc(x, eps) / cs
        return ans
    }
}