package trigonometry

import CsvWriter.Companion.writeCsv
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import kotlin.math.*

class Sin {
    companion object {
        fun calc(x: Double, eps: Double = 10.0.pow(-9.0)): Double {
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
}