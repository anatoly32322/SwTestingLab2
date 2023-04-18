package csvWriter

import java.io.File

object CsvWriter {
    fun writeCsv(x: Double, res: Double, filepath: String = "results.csv") {
        val text = "$x,$res\n"
        val file: File = File(filepath)
        val isFileCreated: Boolean = file.createNewFile()
        if (isFileCreated) {
            file.writeText("x,res\n")
        }
        file.appendBytes(text.toByteArray())
    }
}