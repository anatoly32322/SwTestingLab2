package project.trigonometry

import kotlin.math.pow
import kotlin.math.sqrt

class Cos : TrigonometryInterface {
    override fun calc(x_: Double, eps: Double): Double {
        if (x_.equals(Double.NaN))
            return Double.NaN
        var x = x_
        while (x > Math.PI)
            x -= 2 * Math.PI
        while (x < -Math.PI)
            x += 2 * Math.PI
        val ans: Double = if (x > Math.PI / 2 || x < -Math.PI / 2)
            -sqrt(1 - Sin().calc(x, eps).pow(2))
        else
            sqrt(1 - Sin().calc(x, eps).pow(2))
        return ans
    }
}