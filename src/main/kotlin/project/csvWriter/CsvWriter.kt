package project.csvWriter

import java.io.File
import project.function.Function

object CsvWriter {
    private fun writeCsv(x: Double, res: Double, filepath: String = "src/main/resources/results.csv") {
        val text = "$x,$res\n"
        val file: File = File(filepath)
        val isFileCreated: Boolean = file.createNewFile()
        if (isFileCreated) {
            file.writeText("x,res\n")
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
}