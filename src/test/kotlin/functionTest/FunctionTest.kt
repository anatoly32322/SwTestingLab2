package functionTest

import com.github.doyaaaaaken.kotlincsv.client.CsvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.mockito.Mockito
import project.function.Function
import project.logarithms.*
import project.trigonometry.*


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FunctionTest {

    companion object {
        val logCsvPath: String = "./src/main/resources/log.csv"
        val lnCsvPath: String = "./src/main/resources/ln.csv"
        val cosCsvPath: String = "./src/main/resources/cos.csv"
        val cotCsvPath: String = "./src/main/resources/cot.csv"
        val secCsvPath: String = "./src/main/resources/sec.csv"
        val sinCsvPath: String = "./src/main/resources/sin.csv"
        val tanCsvPath: String = "./src/main/resources/tan.csv"
        val logMock: Log = Mockito.mock(Log::class.java)
        val lnMock: Ln = Mockito.mock(Ln::class.java)
        val cosMock: Cos = Mockito.mock(Cos::class.java)
        val cotMock: Cot = Mockito.mock(Cot::class.java)
        val secMock: Sec = Mockito.mock(Sec::class.java)
        val sinMock: Sin = Mockito.mock(Sin::class.java)
        val tanMock: Tan = Mockito.mock(Tan::class.java)

        @JvmStatic
        @BeforeAll
        fun setup() {
            val reader: CsvReader = csvReader()

            reader.open(lnCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.`when`(lnMock.calc(it[0].toDouble()))
                        .thenReturn(it[1].toDouble())
                }
            }

            reader.open(logCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.`when`(logMock.calc(it[0].toDouble(), it[1].toDouble()))
                        .thenReturn(it[2].toDouble())
                }
            }

            reader.open(cosCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.`when`(cosMock.calc(it[0].toDouble()))
                        .thenReturn(it[1].toDouble())
                }
            }

            reader.open(cotCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.`when`(cotMock.calc(it[0].toDouble()))
                        .thenReturn(it[1].toDouble())
                }
            }

            reader.open(secCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.`when`(secMock.calc(it[0].toDouble()))
                        .thenReturn(it[1].toDouble())
                }
            }

            reader.open(sinCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.`when`(sinMock.calc(it[0].toDouble()))
                        .thenReturn(it[1].toDouble())
                }
            }

            reader.open(tanCsvPath) {
                readAllAsSequence().forEach {
                    Mockito.`when`(tanMock.calc(it[0].toDouble()))
                        .thenReturn(it[1].toDouble())
                }
            }
        }
    }
    @ParameterizedTest
    @CsvFileSource(resources = ["/in.csv"])
    @DisplayName("test log")
    fun testLog(value: Double, expected: Double) {
        Assertions.assertEquals(
            expected,
            Function(
                sn = sinMock,
                cs = cosMock,
                ct = cotMock,
                sc = secMock,
                tn = tanMock,
                ln = lnMock,
                lg = Log()
            ).calc(value),
            0.001
        )
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/in.csv"])
    @DisplayName("test ln")
    fun testLn(value: Double, expected: Double) {
        Assertions.assertEquals(
            expected,
            Function(
                sn = sinMock,
                cs = cosMock,
                ct = cotMock,
                sc = secMock,
                tn = tanMock,
                ln = Ln(),
                lg = logMock
            ).calc(value),
            0.001
        )
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/in.csv"])
    @DisplayName("test sin")
    fun testSin(value: Double, expected: Double) {
        Assertions.assertEquals(
            expected,
            Function(
                sn = Sin(),
                cs = cosMock,
                ct = cotMock,
                sc = secMock,
                tn = tanMock,
                ln = lnMock,
                lg = logMock
            ).calc(value),
            0.001
        )
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/in.csv"])
    @DisplayName("test cos")
    fun testCos(value: Double, expected: Double) {
        Assertions.assertEquals(
            expected,
            Function(
                sn = sinMock,
                cs = Cos(),
                ct = cotMock,
                sc = secMock,
                tn = tanMock,
                ln = lnMock,
                lg = logMock
            ).calc(value),
            0.001
        )
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/in.csv"])
    @DisplayName("test cot")
    fun testCot(value: Double, expected: Double) {
        Assertions.assertEquals(
            expected,
            Function(
                sn = sinMock,
                cs = cosMock,
                ct = Cot(),
                sc = secMock,
                tn = tanMock,
                ln = lnMock,
                lg = logMock
            ).calc(value),
            0.001
        )
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/in.csv"])
    @DisplayName("test sec")
    fun testSec(value: Double, expected: Double) {
        Assertions.assertEquals(
            expected,
            Function(
                sn = sinMock,
                cs = cosMock,
                ct = cotMock,
                sc = Sec(),
                tn = tanMock,
                ln = lnMock,
                lg = logMock
            ).calc(value),
            0.001
        )
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/in.csv"])
    @DisplayName("test tan")
    fun testTan(value: Double, expected: Double) {
        Assertions.assertEquals(
            expected,
            Function(
                sn = sinMock,
                cs = cosMock,
                ct = cotMock,
                sc = secMock,
                tn = Tan(),
                ln = lnMock,
                lg = logMock
            ).calc(value),
            0.001
        )
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/in.csv"])
    @DisplayName("test function")
    fun testFunction(value: Double, expected: Double) {
        Assertions.assertEquals(Function().calc(value), expected, 0.001)
    }
}