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

    val myLittleLambda: (HashSet<Int>, Int) -> Int = myLittleLambda@{ input, targetSum ->
        input.forEach { curr ->
            val intRequired = targetSum - curr
            if (input.contains(intRequired)) {
                return@myLittleLambda curr * intRequired
            }
        }
        throw NoSolutionException("No solution found to puzzle 1-1")
    }

    println ("Day1-1 solution: ${day1puzzle1(input)}")
    println ("Day1-2 solution: ${day1puzzle1(input)}")
}

fun day1puzzle1(input: HashSet<Int>): Int {

    input.forEach { curr ->
        val intRequired = 2020 - curr
        if (input.contains(intRequired)) {
            return curr * intRequired
        }
    }
    throw NoSolutionException("No solution found to puzzle 1-1")
}

fun day1puzzle2(input: HashSet<Int>): Int {
    input.forEach { curr ->
        val req = 2020 - curr
        if (input.contains(req)) {
            return curr * req
        }
    }
    throw NoSolutionException("No solution found to puzzle 1-1")
}