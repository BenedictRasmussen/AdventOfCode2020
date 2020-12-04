package adventofcode

import utils.Utilities

// Over-engineering excellence: apply Strategy pattern for determining which policy to use
fun main(args: Array<String>) {
    var oldPolicyCompliantCount = 0
    var newPolicyCompliantCount = 0
    val iterator = Utilities.readInput("day2").iterator()
    while (iterator.hasNext()) {
        val split = iterator.next().split(" ") // Next line
        val bounds = split[0].split("-").map { it.toInt() }
        val char = split[1][0] // The char we are looking for
        val password = split[2]

        if (password.filter { it == char }.length in bounds[0]..bounds[1]) {
            oldPolicyCompliantCount++
        }

        if ((password[bounds[0] - 1] == char) xor (password[bounds[1] - 1] == char)) {
            newPolicyCompliantCount++
        }
    }

    println("oldPolicyCompliantCount=$oldPolicyCompliantCount, newPolicyCompliantCount=$newPolicyCompliantCount")
}
