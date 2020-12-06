package adventofcode

import utils.Utilities

/*
 * Purposefully a bit heavy in an effort to play with some syntax
 */

enum class PassportValues(val key: String) {
    BYR("byr"), IYR("iyr"), EYR("eyr"), HGT("hgt"), HCL("hcl"), ECL("ecl"), PID("pid")
}

enum class EyeColor(val color: String) {
    AMB("amb"), BLU("blu"), BRN("brn"), GRY("gry"), GRN("grn"), HZL("hzl"), OTH("oth")
}

fun String.isNotEmptyOrBlank(): Boolean = this != null && this.isNotBlank()

data class Passport(val birthYear: Int,  val issueYear: Int,  val exprYear: Int, val height: String,
                    val hairColor: String, val eyeColor: String, val passportId: String) {
    companion object {
        val heightRegex = "1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in".toRegex()
        val hairColorRegex = "#[0-9|a-f]{6}".toRegex()
        val passportIdRegex = "[0-9]{9}".toRegex()
    }

    fun isValidPart2(): Boolean = when {
        this.birthYear !in 1920..2002 ||
                this.issueYear !in 2010..2020 ||
                this.exprYear !in 2020..2030 ||
                EyeColor.values().none{ it.color == this.eyeColor } ||
                heightRegex.matchEntire(this.height) == null ||
                hairColorRegex.matchEntire(this.hairColor) == null ||
                passportIdRegex.matchEntire(this.passportId) == null
        -> false
        else -> true
   }
}

fun main(args: Array<String>) {
    val input = Utilities.readInput("day4")
    var validPassportsPart1 = 0
    var validPassportsPart2 = 0

    val iterator = input.iterator()
    while (iterator.hasNext()) {
        val passportValues = mutableMapOf<String, String?>()
        PassportValues.values().forEach { passportValues[it.key] = null }

        // Repeat to gather all elements of passport
        var line = iterator.next()
        while (line.isNotEmptyOrBlank()) {
            line.split(' ').forEach{
                val parts = it.split(':')
                passportValues[parts[0]] = parts[1]
            }
            line = if (iterator.hasNext()) {
                iterator.next()
            } else {
                ""
            }
        }

        if (passportValues.values.none { it == null }) {
            val passport = Passport(
                    passportValues[PassportValues.BYR.key]!!.toInt(),
                    passportValues[PassportValues.IYR.key]!!.toInt(),
                    passportValues[PassportValues.EYR.key]!!.toInt(),
                    passportValues[PassportValues.HGT.key]!!,
                    passportValues[PassportValues.HCL.key]!!,
                    passportValues[PassportValues.ECL.key]!!,
                    passportValues[PassportValues.PID.key]!!
            )

            validPassportsPart1++
            if (passport.isValidPart2()) {
                validPassportsPart2++
            }
        }
    }

    println("Part 1: $validPassportsPart1 (Ans: 226)")
    println("Part 2: $validPassportsPart2 (Ans: 160)")
}
