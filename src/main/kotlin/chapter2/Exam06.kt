package chapter2

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException
import java.util.*

class Exam06 {

}

fun main(args: Array<String>) {
    //mapIteration()
    listIteration()
    println(isLetter('k'))
    println(isNotDigit('k'))
    println(recognize('%'))
    println("Kotlin" in setOf("Java","Scala"))

    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))

}

fun mapIteration() {
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(Character.getNumericValue(c))
        binaryReps[c] = binary
    }

    for ((letter,binary) in binaryReps) {
        println("$letter = $binary")
    }
}

fun listIteration() {
    val list = arrayListOf("10","111","1001")
    for ( (index, element) in list.withIndex()) {
        println("$index: $element")
    }
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) =
    when (c) {
        in '0'..'9' -> "digit"
        in 'a'..'z', in 'A'..'Z' -> "letter"
        else -> "I don't know"
    }

fun readNumber(reader: BufferedReader) : Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    println(number)
}

fun testException(number: Int) {
    val percentage =
        if (number in 0..100)
            number
        else
            throw IllegalArgumentException("throw exception")
}

