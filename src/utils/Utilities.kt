package utils

import java.io.File

class Utilities {
    companion object {
        fun readInput(filename: String): List<String> {
            return File(FILEPATH + filename).readLines()
        }
    }
}