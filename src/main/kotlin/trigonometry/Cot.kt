package trigonometry

import CsvWriter.Companion.writeCsv
import kotlin.math.*

object Cot {
    @JvmStatic
    fun calc(x: Double, eps: Double = 10.0.pow(-9.0)): Double {
        val sn = Sin.calc(x, eps)
        if (sn == 0.0)
            throw Exception("x != pi/2 + pi*n")
        val ans = Cos.calc(x, eps) / sn
        writeCsv(x, ans)
        return ans
    }
}