package adventofcode

import utils.Utilities

fun main(args: Array<String>) {
    val input = Utilities.readInput("day1")
            .map { it.toInt() }
            .toHashSet()

    val solver: (HashSet<Int>, Int) -> Int? = myLittleLambda@{ input, targetSum ->
        input.forEach { curr ->
            val intRequired = targetSum - curr
            if (input.contains(intRequired)) {
                return@myLittleLambda curr * intRequired // Returns the outer lambda
            }
        }
        null // Return null for no results
    }

    println("Day1-1 solution: ${solver(input, 2020)}")

    input.forEach { curr ->
        val match = solver(input, 2020 - curr)
        if (match != null) {
            println("Day1-2 solution: ${match * curr}")
            return // Returns main
        }
    }
}