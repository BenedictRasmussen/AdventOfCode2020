package adventofcode

import utils.Utilities

fun main(args: Array<String>) {
    val input = Utilities.readInput("day3")
    val pathingOptions = listOf<Pair<Int, Int>>(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
//    val pathingOptions = listOf<Pair<Int, Int>>(Pair(1, 2))
    var treeMult = 1
    pathingOptions.forEach {
        val trees = treeChecker(input, it)
        println("Pathing: $it, treesHit: $trees, treeMult before mult: $treeMult")
        treeMult *= trees
    }
    //816992744 too low
    println("Trees mult: $treeMult")
}

// pathing.first is right movement, pathing.second is downward movement
fun treeChecker(input: List<String>, pathing: Pair<Int, Int>): Int {
    val iterator = input.iterator()
    var trees = 0
    // prime the loop
    var line = iterator.next()
    var currPos = pathing.first

    println(line)
    while (iterator.hasNext()) {
        line = iterator.next()
        var output = line.toCharArray()
        output[currPos] = 'O'

        if (line[currPos] == '#') {
            output[currPos] = 'X'
            trees++
        }

//        println(output)
        currPos += pathing.first
        if (currPos >= line.length) {
            currPos -= line.length
        }

        var skips = pathing.second
        while (skips > 1 && iterator.hasNext()) {
            skips--
            println(iterator.next())
        }
        println(output)
    }
    return trees
}