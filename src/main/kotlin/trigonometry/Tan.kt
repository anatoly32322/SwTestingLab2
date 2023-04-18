package trigonometry

import csvWriter.CsvWriter
import kotlin.math.pow

class Tan {
    fun calc(x: Double, eps: Double = 10.0.pow(-9.0)): Double {
        val cs = Cos().calc(x, eps)
        if (cs == 0.0)
            return Double.NaN
        val ans = Sin().calc(x, eps) / cs
        CsvWriter.writeCsv(x, ans)
        return ans
    }
}