package adventofcode

import org.junit.Assert
import org.junit.Test

class Day5Test {
    private val testPass1 = "FBFBBFFRLR"
    private val testPass2 = "FBFBBFFLRL"
    private val testPassLLL = "FBFBBFFLLL"
    private val testPassRRR = "FBFBBFFRRR"

    @Test
    fun `Calling findRow should calculate row`() {
        val boardingPass = BoardingPass(testPass1)
        Assert.assertEquals(44, boardingPass.findRow())
    }

    @Test
    fun `Calling findColumn with RLR should calculate column`() {
        val boardingPass = BoardingPass(testPass1)
        Assert.assertEquals(5, boardingPass.findColumn())
    }

    @Test
    fun `Calling findColumn with LRL should calculate column`() {
        val boardingPass = BoardingPass(testPass2)
        Assert.assertEquals(2, boardingPass.findColumn())
    }

    @Test
    fun `Calling findColumn with LLL should calculate column`() {
        val boardingPass = BoardingPass(testPassLLL)
        Assert.assertEquals(0, boardingPass.findColumn())
    }

    @Test
    fun `Calling findColumn with RRR should calculate column`() {
        val boardingPass = BoardingPass(testPassRRR)
        Assert.assertEquals(7, boardingPass.findColumn())
    }

    @Test
    fun `Calling getSeatId should calculate the seat ID`() {
        val boardingPass = BoardingPass(testPass1)
        boardingPass.row = 44
        boardingPass.column = 5
        Assert.assertEquals(357, boardingPass.getSeatId())
    }
}