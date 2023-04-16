package trigonometry

import CsvWriter.Companion.writeCsv
import kotlin.math.*

object Sin {
    @JvmStatic
    fun calc(x_: Double, eps: Double = 10.0.pow(-9.0)): Double {
        if (x_.equals(Double.NaN)) {
            writeCsv(Double.NaN, Double.NaN)
            return Double.NaN
        }
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
        writeCsv(x, ans)
        return ans
    }
}