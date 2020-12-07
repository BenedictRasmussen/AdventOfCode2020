package adventofcode

import org.junit.Assert
import org.junit.Test

class Day5Test {
    private val testPass1 = "FBFBBFFRLR"

    @Test
    fun `Calling findRow should calculate row`() {
        val boardingPass = BoardingPass(testPass1)
        Assert.assertEquals(44, boardingPass.findRow())
    }

    @Test
    fun `Calling findColumn should calculate column`() {
        val boardingPass = BoardingPass(testPass1)
        Assert.assertEquals(5, boardingPass.findColumn())
    }

    @Test
    fun `Calling getSeatId should calculate the seat ID`() {
        val boardingPass = BoardingPass(testPass1)
        boardingPass.row = 44
        boardingPass.column = 5
        Assert.assertEquals(357, boardingPass.getSeatId())
    }
}