package adventofcode

import utils.Utilities

fun main(args: Array<String>) {
    val input = Utilities.readInput("day5")
    val boardingPasses = input.map{ BoardingPass(it) }.sortedBy { it.getSeatId() }
    println("Largest seat ID: ${boardingPasses.maxOf { it.getSeatId() }}")

    for (i in 0 until boardingPasses.size - 1) {
        if (boardingPasses[i+1].getSeatId() == boardingPasses[i].getSeatId() + 2) {
            println("Santa's seat: ${boardingPasses[i].getSeatId() + 1}")
        }
    }
}

class BoardingPass(private val boardingPass: String) {
    // Setting as internal to make unit testing easier without having to mock a bunch
    internal var row = -1
    internal var column = -1

    init {
        this.row = findIndex(127, 0, 6, 'B')
        this.column = findIndex(7, 7, 9, 'R')
    }

    private fun findIndex(numSeats: Int, startPosition:Int, endPosition:Int, upperChar: Char): Int {
        var lowIndex = 0
        var highIndex = numSeats

        for (index in startPosition..endPosition) {
            val newPos = (lowIndex + highIndex) / 2
            if (this.boardingPass[index] == upperChar) {
                lowIndex = newPos
            } else {
                highIndex = newPos
            }
        }

        return highIndex
    }

    fun getSeatId(): Int = row * 8 + column
}

