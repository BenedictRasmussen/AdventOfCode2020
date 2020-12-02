package adventofcode

import utils.FILEPATH
import utils.NoSolutionException
import java.io.File

fun main(args: Array<String>) {
    val filename = FILEPATH + "day1-1"

    val input = File(filename)
            .readLines()
            .map { it.toInt() }
            .toHashSet()

    val solver: (HashSet<Int>, Int) -> Int? = myLittleLambda@{ input, targetSum ->
        input.forEach { curr ->
            val intRequired = targetSum - curr
            if (input.contains(intRequired)) {
                return@myLittleLambda curr * intRequired
            }
        }
        null
    }

    val solution1: Int? = solver(input, 2020)

    println("Day1-1 solution: $solution1")

    input.forEach { curr ->
        val match = solver(input, 2020 - curr)
        if (match != null) {
            println("Day1-2 solution: ${match * curr}")
            return
        }
    }
}