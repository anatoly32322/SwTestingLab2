package logarithms

import CsvWriter.Companion.writeCsv
import kotlin.math.absoluteValue
import kotlin.math.pow

class Ln {
    companion object {
        fun calc(x: Double, eps: Double = 10.0.pow(-9.0)): Double {
            if (x.equals(Double.NaN))
                return Double.NaN
            if (x <= 0.0)
                throw Exception("\'x\' must be positive")
            val const: Double = (x - 1).pow(2) / (x + 1).pow(2)
            var ans: Double = 0.0
            var cur: Double = (x - 1) / (x + 1)
            var step: Int = 1
            while (cur.absoluteValue > eps) {
                ans += cur
                cur = (2 * step - 1) * cur * const / (2 * step + 1)
                step++
            }
            writeCsv(x, ans)
            return ans * 2
        }
    }
}