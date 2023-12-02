package io.github.advent.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalibratorTest {


    @ParameterizedTest
    @CsvSource("1abc2,12", "pqr3stu8vwx,38", "a1b2c3d4e5f,15", "treb7uchet,77")
    fun `should calibrate from calibration value`(calibrationValue: String, expectedResult: Int) {
        val calibrator = Calibrator()
        val calibrationResult = calibrator.calibrate(calibrationValue)
        assertThat(calibrationResult).isEqualTo(expectedResult)
    }
}