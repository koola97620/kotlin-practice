package codingtest.programmers.stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class 다리를지나는트럭 {

    @Test
    fun case1() {
        val bridgeLength = 2
        val weight = 10
        val truckWeights = intArrayOf(7,4,5,6)
        val solution = solution(bridgeLength, weight, truckWeights)
        assertThat(solution).isEqualTo(8)
    }

    @Test
    fun case2() {
        val bridgeLength = 100
        val weight = 100
        val truckWeights = intArrayOf(10)
        val solution = solution(bridgeLength, weight, truckWeights)
        assertThat(solution).isEqualTo(101)
    }

    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val waitedTrucks = LinkedList<Truck>()
        for (i in 0..truck_weights.size) {
            waitedTrucks.push(Truck(truck_weights[0], 0))
        }

        val bridge = Bridge(bridge_length, weight)
        var time = 0;
        while (!waitedTrucks.isEmpty()) {
            val truck = waitedTrucks.peek()
            if (bridge.isOverWeightBridge(truck)) {
                bridge.move()
                time++
                continue
            }
            bridge.add(waitedTrucks.poll())
            time++
        }
        return time
    }

}

class Bridge(val length: Int, val maxWeight: Int) {
    private val queue = LinkedList<Truck>()

    fun isEmpty() : Boolean = queue.isEmpty()
    fun isOverWeightBridge(truck: Truck) : Boolean = truck.weight + currentWeight() > maxWeight

    fun add(truck: Truck) {
        queue.add(truck)
        move()
    }

    fun move() {
        queue.forEach {
            it.move()
        }
        if (queue.peek().currentPosition == length)
            queue.poll()
    }

    private fun currentWeight() : Int {
        return queue.sumOf { it -> it.weight }
    }

}

class Truck(val weight: Int, var currentPosition: Int) {

    fun move() {
        currentPosition++
    }

}
