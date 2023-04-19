package project.trigonometry

import kotlin.math.absoluteValue
import kotlin.math.pow

class Sin : TrigonometryInterface {
    override fun calc(x_: Double, eps: Double): Double {
        if (x_.equals(Double.NaN))
            return Double.NaN
        var x = x_
        while (x > Math.PI)
            x -= 2 * Math.PI
        while (x < -Math.PI)
            x += 2 * Math.PI
        var ans = 0.0
        var tmp = 1.0
        var coef = 1
        var fact = 1.0
        var i = 1
        var n = 1
        while (tmp.absoluteValue > eps) {
            tmp = coef * x.pow(2 * i - 1) / fact
            ans += tmp
            fact *= (n + 1) * (n + 2)
            n += 2
            i++
            coef *= -1
        }
        return ans
    }
}