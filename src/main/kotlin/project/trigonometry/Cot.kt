package project.trigonometry

import kotlin.math.abs

class Cot : TrigonometryInterface {
    override fun calc(x: Double, eps: Double): Double {
        val sn = Sin().calc(x, eps)
        if (abs(sn) < 1e-9)
            return Double.NaN
        val ans = Cos().calc(x, eps) / sn
        return ans
    }
}