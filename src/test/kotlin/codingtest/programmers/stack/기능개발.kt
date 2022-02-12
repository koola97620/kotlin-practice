package codingtest.programmers.stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.ArrayList

class 기능개발 {

    @Test
    fun case1() {
        val progresses = intArrayOf(93, 30, 55)
        val speeds = intArrayOf(1, 30, 5)
        val result = solution(progresses, speeds)
        assertThat(result).containsExactly(2, 1);
    }

    @Test
    fun case2() {
        val progresses = intArrayOf(95, 90, 99, 99, 80, 99)
        val speeds = intArrayOf(1, 1, 1, 1, 1, 1)
        val result = solution(progresses, speeds)
        assertThat(result).containsExactly(1, 3, 2);
    }

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val taskQueue: TaskQueue = TaskQueue(progresses, speeds)
        return taskQueue.calculateDeployCount()
    }
}

class TaskQueue(progresses: IntArray, speeds: IntArray) {
    private val queue = LinkedList<Task>()

    init {
        for ((index, progress) in progresses.withIndex()) {
            val task = Task(progress, speeds[index])
            queue.offer(task)
        }
    }

    fun getFirstRemainWorkload() : Int =
        if (!queue.isEmpty()) {
            queue.peek().getRemainWorkload()
        } else
            0

    fun calculateDeployCount() : IntArray {
        var result: Int = 0
        val list = ArrayList<Int>()
        var criteria = getFirstRemainWorkload()

        while(!queue.isEmpty()) {
            val task = queue.peek()
            if (task.getRemainWorkload() <= criteria) {
                result++
                queue.poll()
            } else {
                list.add(result)
                result = 0
                criteria = task.getRemainWorkload()
            }
        }
        list.add(result)
        return list.toIntArray()
    }
}

class Task (progress: Int, speed: Int) {
    private val remainWorkload: Int

    init {
        remainWorkload = calculateRemain(progress, speed)
    }

    fun getRemainWorkload() : Int {
        return remainWorkload
    }

    private fun calculateRemain(progress: Int, speed: Int) : Int {
        val remain = 100 - progress
        return if (remain % speed == 0) {
            remain / speed
        } else {
            (remain / speed) + 1
        }
    }

}
