package chapter2

class Exam05 {
}

fun main(args: Array<String>) {
    //startFizzBuzz()
    startFizzBuzzReverse()
}

fun startFizzBuzz() {
    for (i in 1..100) {
        println(fizzBuzz(i))
    }
}

fun startFizzBuzzReverse() {
    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }
}


fun fizzBuzz(i: Int) =
    when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i "
    }
