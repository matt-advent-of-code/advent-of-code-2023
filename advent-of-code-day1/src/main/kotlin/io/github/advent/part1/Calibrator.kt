package io.github.advent.part1

open class Calibrator {

    open fun calibrate(calibrationValue: String) : Int {
        return calibrationValue.filter { it.isDigit() }.let { "${it.first()}${it.last()}" }.toInt()
    }
}