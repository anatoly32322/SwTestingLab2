package project.logarithms

interface LogarithmsInterface {
    fun calc(x: Double, base: Double=Math.E, eps: Double=1e-9) : Double
}