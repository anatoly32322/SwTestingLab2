package trigonometry

import kotlin.math.*

class Cot {
    val eps = 0.01

    fun calc(x : Double) : Double {
        var result = 1.0 / x
        var term = -x
        var i = 1
        for (i in 1..100) {
            term *= -(2 * i - 1) * x * x / (2 * i + 1)
            val nextTerm = term / x
            if (nextTerm == 0.0) {
                break
            }
            result += (if (i % 2 == 0) -2 else 2) * nextTerm
        }
        return result
//        var y = x
//        var result : Double = 1.0 / y
//        var term : Double = 1.0
//        var n : Int = 1
//        for (i in 1..100) {
//            y = y.pow(2)
//            term *= -y / ((2 * n - 1) * (2 * n))
//            result += term
//            n += 1
//            println("______________")
//            println(term)
//            println(y)
//        }
//
//        return result
    }
}