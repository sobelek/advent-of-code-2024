import kotlin.math.abs

fun main() {
    fun checkReport(report: List<Int>): Boolean {
        var prev: Int? = null
        var increasing: Boolean? = null
        for (entry in report) {
            if (prev == null) {
                prev = entry
                continue
            }
            if (prev == entry){
                return false
            }
            if (abs(prev - entry) > 3){
                return false
            }
            if (increasing == null) {
                increasing = prev < entry
            } else {
                if (increasing != prev < entry) {
                    return false
                }
            }
            prev = entry
        }

        return true
    }

    fun part1(input: List<String>): Int {
        var reports = mutableListOf<List<Int>>()

        input.map { it ->
            it.split(" ").filterNot { it.isBlank() }.map { it.toInt() }
        }.forEach {
            reports.add(it)
        }
        var result = 0
        reports.map { it ->
            if (checkReport(it)) {
                result += 1
            }
        }
        return result
    }

    fun permuteCheck(report: List<Int>): Boolean {
      for(i in report.size-1 downTo 0){
          val fixedReport = report.toMutableList()
          fixedReport.removeAt(i)
            if (checkReport(fixedReport)){
                return true
            }
      }
        return false
    }
    fun part2(input: List<String>): Int {

        var reports = mutableListOf<List<Int>>()

        input.map { it ->
            it.split(" ").filterNot { it.isBlank() }.map { it.toInt() }
        }.forEach {
            reports.add(it)
        }
        var result = 0
        reports.map { it ->
            if (checkReport(it)) {
                result += 1
            }else{
                if (permuteCheck(it)){
                    result += 1
                }
            }
        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
