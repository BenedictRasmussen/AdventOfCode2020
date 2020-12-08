package adventofcode

import utils.isNotEmptyOrBlank
import utils.Utilities

fun main(args: Array<String>) {
    val input = Utilities.readInput("day6")
    val iterator = input.iterator();
    var totalYes = 0
    var groupYes = 0

    while (iterator.hasNext()) {
        var line = iterator.next()
        var numLines = 0 // Represents number of people in group
        val charSet = HashSet<Char>()
        val charMap = HashMap<Char, Int>()

        while (line.isNotEmptyOrBlank()) {
            numLines++
            line.forEach {
                charSet.add(it)

                if (charMap.containsKey(it)) {
                    charMap[it] = charMap[it]!!.plus(1) // This can't be null, don't know why it insists on null-safe op
                } else {
                    charMap[it] = 1
                }
            }
            line = if (iterator.hasNext()) {
                iterator.next()
            } else {
                 ""
            }
        }

        totalYes += charSet.size
        groupYes += charMap.filter { it.value == numLines }.size
    }

    println("TotalYes: $totalYes, GroupYes: $groupYes")
}