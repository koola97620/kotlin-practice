package chapter2

import java.util.*

class Rectangle(val height: Int, val weight: Int) {
    val isSquare: Boolean
        get() = height == weight
//        get() {
//            return height == weight
//        }

}

fun createRandomRectangle() : Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}
