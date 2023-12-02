package io.github.advent.part1

fun main() {
    val calibrator = Calibrator()
    Calibrator::class.java.getResource("/input.txt")?.readText()?.lines()
        ?.sumOf { calibrator.calibrate(it) }.let { println(it) }
}
