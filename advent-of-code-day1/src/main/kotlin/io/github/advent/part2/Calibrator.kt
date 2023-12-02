package io.github.advent.part2

class Calibrator {

    private val replacements = mapOf(
        "zero" to "0",
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )

    fun calibrate(calibrationValue: String): Int {
        val digits = mutableListOf<String>()
        calibrationValue.forEachIndexed { index, c ->
            if (c.isDigit()) digits.add(c.toString())
            replacements.keys.find { calibrationValue.substring(index).startsWith(it) }?.let { key ->
                replacements[key]?.let { digits.add(it) }
            }
        }
        return "${digits.first()}${digits.last()}".toInt()
    }
}