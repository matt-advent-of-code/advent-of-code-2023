package io.github.advent.part2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GamePlayerTest {

    @ParameterizedTest
    @CsvSource(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green|4|2|6",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue|1|3|4",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red|20|13|6",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red|14|3|15",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green|6|3|2",
        delimiter = '|'
    )
    fun `finds min required cubes`(input : String, red: Int, green: Int, blue: Int) {
        val gamePlayer = GamePlayer()
        val result = gamePlayer.play(input)
        assertAll(
            { assertThat(result.minRed).isEqualTo(red) },
            { assertThat(result.minBlue).isEqualTo(blue) },
            { assertThat(result.minGreen).isEqualTo(green) },
        )
    }
}