package chapter3.makeCollection

class Exam04 {
}

fun main(args : Array<String>) {
    val strings: List<String> = listOf("first", "second", "fourteeth")
     println(strings.last())
    val numbers: Collection<Int> = setOf(1,14,2)
    println(numbers.maxOrNull())
}

