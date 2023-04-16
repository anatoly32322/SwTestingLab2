package trigonometry

import CsvWriter.Companion.writeCsv
import kotlin.math.pow
import kotlin.math.sqrt

object Cos {
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
        val ans: Double = if (x > Math.PI / 2 || x < -Math.PI / 2)
            -sqrt(1 - Sin.calc(x, eps).pow(2))
        else
            sqrt(1 - Sin.calc(x, eps).pow(2))
        writeCsv(x, ans)
        return ans
    }
}