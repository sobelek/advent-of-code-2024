
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var leftList = mutableListOf<Int>()
        var rightList = mutableListOf<Int>()

        input.map { it ->
            it.split(" ").filterNot { it.isBlank() }
        }.forEach {
            leftList.add(it[0].toInt())
            rightList.add(it[1].toInt())
        }

        leftList.sort()
        rightList.sort()

        var result = 0
        leftList.zip(rightList).forEach {
            result += abs(it.first - it.second)
        }

        return result

    }

    fun part2(input: List<String>): Int {

        var leftList = mutableListOf<Int>()
        var rightMap = mutableMapOf<Int, Int>()
        input.map { it ->
            it.split(" ").filterNot { it.isBlank() }
        }.forEach {
            leftList.add(it[0].toInt())
            rightMap.set(it[1].toInt(), rightMap.getOrDefault(it[1].toInt(), 0) + 1)
        }

        var result = 0
        leftList.forEach { it ->
            rightMap.get(it)?.let { mapResult ->
                result += mapResult * it
            }
        }
            return result
        }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
