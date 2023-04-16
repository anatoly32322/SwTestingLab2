package trigonometry

import CsvWriter.Companion.writeCsv
import kotlin.math.pow

object Tan {
    @JvmStatic
    fun calc(x: Double, eps: Double = 10.0.pow(-9.0)): Double {
        val cs = Cos.calc(x, eps)
        if (cs == 0.0)
            throw Exception("x != pi*n")
        val ans = Sin.calc(x, eps) / cs
        writeCsv(x, ans)
        return ans
    }
}