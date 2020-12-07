package adventofcode


fun main(args: Array<String>) {
    
}

class BoardingPass(private val boardingPass: String) {
    // Setting as internal to make unit testing easier without having to mock a bunch
    internal var row = -1
    internal var column = -1

    fun findRow(): Int {
        row = findIndex(127, 0, 6, 'B')
        return row
    }

    fun findColumn(): Int {
        column = findIndex(7, 7, 9, 'R')
        return column
    }

    private fun findIndex(numSeats: Int, startPosition:Int, endPosition:Int, upperChar: Char): Int {
        var lowIndex = 0
        var highIndex = numSeats

        for (index in startPosition..endPosition) {
            val char = this.boardingPass[index]
            val newPos = (lowIndex + highIndex) / 2
            println("char: $char (upperChar: $upperChar), lowIndex: $lowIndex, highIndex: $highIndex")
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

