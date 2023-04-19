package project.logarithms

import kotlin.math.absoluteValue
import kotlin.math.pow

class Ln {

    fun calc(x: Double, eps: Double = 10.0.pow(-9.0)): Double {
        if (x.equals(Double.NaN))
            return Double.NaN
        if (x <= 0.0)
            return Double.NaN
        val const: Double = (x - 1).pow(2) / (x + 1).pow(2)
        var ans: Double = 0.0
        var cur: Double = (x - 1) / (x + 1)
        var step: Int = 1
        while (cur.absoluteValue > eps) {
            ans += cur
            cur = (2 * step - 1) * cur * const / (2 * step + 1)
            step++
        }
        return ans * 2
    }
}