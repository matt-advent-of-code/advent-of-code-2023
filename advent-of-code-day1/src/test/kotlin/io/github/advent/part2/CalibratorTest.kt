package io.github.advent.part2

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalibratorTest {

    @ParameterizedTest
    @CsvSource("two1nine,29", "eightwothree,83", "abcone2threexyz,13", "xtwone3four,24",
        "4nineeightseven2,42","zoneight234,14","7pqrstsixteen,76", "337,37", "57sixsix2sevenvkxrsevencmmgv,57"
    , "twonrpvnnmvkh2threejzcpz,23", "two2three,23", "31,31", "2bhfpjnxbttwottrvdmpssgjjvqjhkdskmxjqone,21",
        "ppltwonepcmjdmtc2sixjpqnvpczbmtplqcsz,26", "425six14two46,46", "1oneight,18")
    fun `should calibrate from calibration value`(calibrationValue: String, expectedResult: Int) {
        val calibrator = Calibrator()
        val calibrationResult = calibrator.calibrate(calibrationValue)
        Assertions.assertThat(calibrationResult).isEqualTo(expectedResult)
    }
}