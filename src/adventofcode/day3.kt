package adventofcode

import utils.Utilities

fun main(args: Array<String>) {
    val input = Utilities.readInput("day3")
    val pathingOptions = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
    var treeMult: Long = 1L

    pathingOptions.forEach {
        val trees = treeChecker(input, it)
        treeMult *= trees
    }

    println("Trees mult: $treeMult")
}

// pathing.first is right movement, pathing.second is downward movement
fun treeChecker(input: List<String>, pathing: Pair<Int, Int>): Int {
    val iterator = input.iterator()
    var trees = 0
    // Used to skip rows for certain pathing options
    val skip = {skips: Int, iterator: Iterator<String> ->
        var numSkips = skips
        while (numSkips > 1 && iterator.hasNext()) {
            numSkips--
            iterator.next()
        }
    }

    // prime the loop
    iterator.next()
    var currPos = pathing.first
    skip(pathing.second, iterator)
    while (iterator.hasNext()) {
        val line = iterator.next()

        if (line[currPos] == '#') {
            trees++
        }

        currPos += pathing.first
        if (currPos >= line.length) {
            currPos -= line.length
        }

        skip(pathing.second, iterator)
    }
    return trees
}
