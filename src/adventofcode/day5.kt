package adventofcode

import utils.Utilities


fun main(args: Array<String>) {
    val input = Utilities.readInput("day5")
    val boardingPasses = input.map{ BoardingPass(it) }
    println("Largest seat ID: ${boardingPasses.maxOf { it.getSeatId() }}")
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
            val char = this.boardingPass[index]
            val newPos = (lowIndex + highIndex) / 2
            if (char == upperChar) {
                lowIndex = newPos
            } else {
                highIndex = newPos
            }
        }

        return highIndex
    }

    fun getSeatId(): Int = row * 8 + column
}

