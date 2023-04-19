package project.trigonometry

import kotlin.math.abs

class Sec : TrigonometryInterface {
    override fun calc(x: Double, eps: Double): Double {
        val cs = Cos().calc(x, eps)
        if (abs(cs) < 1e-9)
            return Double.NaN
        val ans = 1.0 / cs
        return ans
    }
}