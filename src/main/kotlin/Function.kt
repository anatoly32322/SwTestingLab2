import trigonometry.*
import logarithms.*
import kotlin.math.pow

class Function(
    val sn: Sin = Sin(),
    val cs: Cos = Cos(),
    val ct: Cot = Cot(),
    val sc: Sec = Sec(),
    val tn: Tan = Tan(),
    val ln: Ln = Ln(),
    val lg: Log = Log()
    ) {
    fun calc(x: Double): Double {
        return if (x <= 0.0)
            (((sn.calc(x) * ct.calc(x) * sn.calc(x) / (sn.calc(x) * ct.calc(x))) +
                    (tn.calc(x) * sc.calc(x) / sc.calc(x))) * (sc.calc(x) - sn.calc(x)))
        else
            (((lg.calc(x, 10.0) + lg.calc(x, 10.0)).pow(3) + lg.calc(x, 10.0)) /
                    (lg.calc(x, 10.0) * (lg.calc(x, 10.0) + lg.calc(x, 2.0)))) *
                    lg.calc(x.pow(3), 2.0) / lg.calc(x, 3.0)
    }
}