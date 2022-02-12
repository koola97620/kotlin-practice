package chapter2

import chapter2.Color.*

class Exam02 {
}

fun main(args: Array<String>) {
    val languages = arrayListOf("Kotlin")
    languages.add("Java")

//    var answer = 42
//    answer = "ans"

    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, ${name}")

    println("Hi, ${if (args.size > 0) args[0] else "someone"} !! ")

    val person = Person("Bob", true)
    println(person.name)
    println(person.isMarried)
    person.isMarried = false
    println(person.isMarried)

    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)

    println(createRandomRectangle().isSquare)

    println(Color.BLUE.rgb())

    println(getMnemonic(Color.BLUE))
    println(getWarmth(GREEN))
    println(mix(RED, YELLOW))
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun getWarmth(color: Color) = when (color) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}


