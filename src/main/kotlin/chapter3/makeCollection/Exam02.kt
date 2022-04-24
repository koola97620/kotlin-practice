package chapter3.makeCollection

import java.lang.StringBuilder

class Exam02 {
}

fun main(args: Array<String>) {
    println(joinToString(listOf(1,2,3), ";","(",")")) // (1;2;3)
    val col = listOf(1,2,3)
    val sep = ";"
    val pre = "("
    val post = ")"
    println(joinToString(col, separator = sep, prefix = pre, postfix = post))

    println(joinToString(col))
    println(joinToString(col, ":"))
    println(joinToString(col, postfix = ";", prefix = "# "))
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)
    for ( (index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
