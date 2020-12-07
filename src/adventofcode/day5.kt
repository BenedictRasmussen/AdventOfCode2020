package adventofcode


fun main(args: Array<String>) {

}

class BoardingPass(val boardingPass: String) {
    // Setting as internal to make unit testing easier without having to mock a bunch
    internal var row = -1
    internal var column = -1

    fun findRow(): Int {
        return row
    }

    fun findColumn(): Int {
        return column
    }

    fun getSeatId(): Int = row * 8 + column
}

