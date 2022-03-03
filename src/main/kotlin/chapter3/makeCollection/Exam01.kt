package chapter3.makeCollection

class Exam01 {
    val set = hashSetOf(1,7,53)
    val list = arrayListOf(1,7,53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

}

fun main(args: Array<String>) {
    val strings = listOf("first", "second", "third")
    println(strings.last())
    println(strings)  // default toString 구현되어있음

    val numbers = setOf(1,4,14)
    println(numbers.maxOrNull())
}


