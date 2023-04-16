import com.github.doyaaaaaken.kotlincsv.client.CsvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import logarithms.*
import trigonometry.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.mockito.Mockito

class Function {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    companion object {
        val logCsvPath: String = "./src/main/resources/log.csv"
        val lnCsvPath: String = "./src/main/resources/ln.csv"
        val cosCsvPath: String = "./src/main/resources/cos.csv"
        val cotCsvPath: String = "./src/main/resources/cot.csv"
        val secCsvPath: String = "./src/main/resources/sec.csv"
        val sinCsvPath: String = "./src/main/resources/sin.csv"
        val tanCsvPath: String = "./src/main/resources/tan.csv"

        @JvmStatic
        @BeforeAll
        fun setup() {
            val reader: CsvReader = csvReader()

            reader.open(logCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.mockStatic(Log::class.java)
                        .`when`<Double> { Log.calc(it[0].toDouble(), it[1].toDouble()) }
                        .thenReturn(it[2].toDouble())
                }
            }

            reader.open(lnCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.mockStatic(Ln::class.java)
                        .`when`<Double> { Ln.calc(it[0].toDouble()) }
                        .thenReturn(it[1].toDouble())
                }
            }

            reader.open(cosCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.mockStatic(Cos::class.java)
                        .`when`<Double> { Cos.calc(it[0].toDouble()) }
                        .thenReturn(it[1].toDouble())
                }
            }

            reader.open(cotCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.mockStatic(Cot::class.java)
                        .`when`<Double> { Cot.calc(it[0].toDouble()) }
                        .thenReturn(it[1].toDouble())
                }
            }

            reader.open(secCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.mockStatic(Sec::class.java)
                        .`when`<Double> { Sec.calc(it[0].toDouble()) }
                        .thenReturn(it[1].toDouble())
                }
            }

            reader.open(sinCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.mockStatic(Sin::class.java)
                        .`when`<Double> { Sin.calc(it[0].toDouble()) }
                        .thenReturn(it[1].toDouble())
                }
            }

            reader.open(tanCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.mockStatic(Tan::class.java)
                        .`when`<Double> { Tan.calc(it[0].toDouble()) }
                        .thenReturn(it[1].toDouble())
                }
            }
        }


        @ParameterizedTest
        @CsvFileSource(resources = ["log.csv"])
        fun test1(value: Double, base: Double, expected: Double) {
            Assertions.assertEquals(expected, Log.calc(value, base))
        }
    }
}