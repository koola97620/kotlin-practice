package chapter2

import java.lang.IllegalArgumentException

class Exam04 {
}

fun main(args: Array<String>) {
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}

fun evalWithLogging(e: Expr) : Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("Sum: ${left} + ${right}")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }
