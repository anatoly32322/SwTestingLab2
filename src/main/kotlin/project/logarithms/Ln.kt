package project.logarithms

import kotlin.math.absoluteValue
import kotlin.math.pow

class Ln : LogarithmsInterface {

    override fun calc(x: Double, base: Double, eps: Double): Double {
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