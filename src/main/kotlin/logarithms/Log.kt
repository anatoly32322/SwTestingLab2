package logarithms

import CsvWriter.Companion.writeCsv
import kotlin.math.pow

object Log {
    @JvmStatic
    fun calc(x: Double, y: Double, eps: Double = 10.0.pow(-9.0)): Double {
        if (y == 1.0)
            throw Exception("\'y\' mustn't be equal to 1")
        val ans = Ln.calc(x, eps) / Ln.calc(y, eps)
        writeCsv(x, ans)
        return ans
    }
}