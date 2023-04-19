package project.trigonometry

import kotlin.math.*

class Cot {
    fun calc(x: Double, eps: Double = 10.0.pow(-9.0)): Double {
        val sn = Sin().calc(x, eps)
        if (abs(sn) < 1e-9)
            return Double.NaN
        val ans = Cos().calc(x, eps) / sn
        return ans
    }
}