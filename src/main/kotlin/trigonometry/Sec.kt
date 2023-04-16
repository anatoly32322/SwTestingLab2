package trigonometry

import CsvWriter.Companion.writeCsv
import kotlin.math.pow

object Sec {
    @JvmStatic
    fun calc(x: Double, eps: Double = 10.0.pow(-9.0)): Double {
        val cs = Cos.calc(x, eps)
        if (cs == 0.0)
            throw Exception("x != pi*n")
        val ans = 1.0 / cs
        writeCsv(x, ans)
        return ans
    }
}