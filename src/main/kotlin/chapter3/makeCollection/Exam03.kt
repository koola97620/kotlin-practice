package chapter3.makeCollection

class Exam03 {

}

fun main(args : Array<String>) {
    println("Kotlin".lastChar())
    val listInt = listOf(1, 2, 3);
    println(listInt.joinToString(separator = "; ", prefix = "(", postfix = ")"))
    println(listInt.joinToString(" "))
    val listString = listOf("A","B","C");
    //println(listInt.join(" "))
    println(listString.join(" "))



}

fun String.lastChar() : Char = this.get(this.length - 1)

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String ="",
    postfix: String=""
) : String {
    val result = StringBuilder(prefix)
    for ( (index, element) in this.withIndex() ) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator,prefix,postfix)


