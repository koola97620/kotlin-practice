package codingtest.programmers.stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class 프린터 {

    @Test
    fun case1() {
        val priorities = intArrayOf(2, 1, 3, 2)
        val location = 2
        val result = solution(priorities, location)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun case2() {
        val priorities = intArrayOf(1, 1, 9, 1, 1, 1)
        val location = 0
        val result = solution(priorities, location)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun case3() {
        val priorities = intArrayOf(1, 1, 9, 1, 8, 1)
        // 1 1 9 *1 8 1
        // 1 9 *1 8 1 1
        // 9 *1 8 1 1 1
        // *1 8 1 1 1
        // 8 1 1 1 *1
        val location = 3
        val result = solution(priorities, location)
        assertThat(result).isEqualTo(6)
    }

    fun solution(priorities: IntArray, location: Int): Int {
        val printQueue = PrintQueue(priorities)
        return printQueue.search(location)
    }
}

class Document(val index: Int, val priority: Int) {
    fun isLowerPriority(maxPriority: Int): Boolean = priority < maxPriority
    fun isEqualIndex(number: Int): Boolean = index == number
    fun isEqualPriority(maxPriority: Int): Boolean = priority == maxPriority
}

class PrintQueue(priorities: IntArray) {
    private val queue = LinkedList<Document>()

    init {
        for ((index, priority) in priorities.withIndex()) {
            queue.offer(Document(index, priority))
        }
    }

    fun search(location: Int): Int {
        var maxPriority = findMaxPriority();
        var number = 1
        while (!queue.isEmpty()) {
            var document = queue.poll()
            if (document.isLowerPriority(maxPriority)) {
                queue.offer(document)
                continue
            } else if (document.isEqualPriority(maxPriority)) {
                if (document.isEqualIndex(location)) {
                    break
                }
                number++
                maxPriority = findMaxPriority()
                continue
            }

            document = queue.peek()
            if (document.isEqualIndex(location)) {
                break
            }
        }
        return number
    }

    private fun findMaxPriority(): Int {
        return queue.maxOf { it -> it.priority }
//        val toList = queue.toList()
//        var max = Int.MIN_VALUE
//        for (document in toList) {
//            if (document.priority > max) {
//                max = document.priority
//            }
//        }
//        return max
    }

}
