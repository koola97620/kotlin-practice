package codingtest.programmers.완전탐색

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class 소수찾기 {

    @Test
    fun case1() {
        val numbers = "17"
        val result = solution(numbers)
        assertThat(result).isEqualTo(3)
    }

    fun solution(numbers: String): Int {
        val numberArray = numbers.split("").toTypedArray()
        val resultSet = hashSetOf<Int>()
        for (i in 1..numberArray.size) {
            createPrimeNumbers(numberArray,i,0,resultSet)
        }

        return resultSet.size
    }

    private fun createPrimeNumbers(numberArray: Array<String>, max: Int, index: Int, resultSet: HashSet<Int>) {
        if (index == max) {
            val sb = StringBuilder()
            for (i in 0 until max) {
                sb.append(numberArray[i])
            }
            val num = sb.toString().toInt()
            if (!isPrime(num)) {
                return
            }
            resultSet.add(num)
        } else {
            for (i in 0 until numberArray.size) {
                swap(numberArray, index, index + i)
                createPrimeNumbers(numberArray, max, index + 1, resultSet)
                swap(numberArray, index, index + i)
            }
        }
    }

    private fun swap(numbers: Array<String>, i: Int, j: Int) {
        val s = numbers[i]
        numbers[i] = numbers[j]
        numbers[j] = s
    }

    private fun isPrime(number: Int) : Boolean {
        if (number < 2) {
            return false
        }

        for (i in 2..number) {
            if (i * i > number) {
                continue
            }

            if (number % i == 0) {
                return false
            }
        }
        return true
    }

}
