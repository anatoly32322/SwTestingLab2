package project.csvWriter

import java.io.File
import project.function.Function
import project.logarithms.LogarithmsInterface
import project.trigonometry.TrigonometryInterface

object CsvWriter {
    private fun writeCsv(
        x: Double,
        res: Double,
        base: Double = Double.NaN,
        filepath: String = "src/main/resources/results.csv"
    ) {
        val text = "$x,$base,$res\n"
        val file: File = File(filepath)
        val isFileCreated: Boolean = file.createNewFile()
        if (isFileCreated) {
            file.writeText("x,base(for logarithm only),res\n")
        }
        file.appendBytes(text.toByteArray())
    }

    fun calcWithSpecificCountOfSteps(from: Double, to: Double, n: Int) {
        var x = from
        val step = (to - from) / n
        do {
            val res = Function().calc(x)
            writeCsv(x, res)
            x += step
        } while (x < to)
    }

    fun calcSpecificTrigonometryFunction(func: TrigonometryInterface, x: Double) : Double {
        val res = func.calc(x)
        writeCsv(x, res)
        return res
    }

    fun calcSpecificLogarithmFunction(func: LogarithmsInterface, x: Double, base: Double) : Double {
        val res = func.calc(x, base)
        writeCsv(x, res, base)
        return res
    }
}