import trigonometry.*
import logarithms.*
import kotlin.math.pow

class Function {
    companion object {
        fun calc(x: Double): Double {
            return if (x <= 0.0)
                (((Sin.calc(x) * Cot.calc(x) * Sin.calc(x) / (Sin.calc(x) * Cot.calc(x))) +
                        (Tan.calc(x) * Sec.calc(x) / Sec.calc(x))) * (Sec.calc(x) - Sin.calc(x)))
            else
                (((Log.calc(x, 10.0) + Log.calc(x, 10.0)).pow(3) + Log.calc(x, 10.0)) /
                        (Log.calc(x, 10.0) * (Log.calc(x, 10.0) + Log.calc(x, 2.0)))) *
                        Log.calc(x.pow(3), 2.0) / Log.calc(x, 3.0)
        }
    }
}