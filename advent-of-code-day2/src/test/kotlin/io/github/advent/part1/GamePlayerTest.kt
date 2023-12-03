package io.github.advent.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GamePlayerTest {

    @ParameterizedTest
    @CsvSource(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green|true",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue|true",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red|false",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red|false",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green|true"
        ,delimiter = '|')
    fun `plays game and determines if possible outcome`(gameInput: String, possible: Boolean) {
        val gamePlayer = GamePlayer(maxRed = 12, maxGreen = 13, maxBlue = 14)
        val game = gamePlayer.play(gameInput)
        assertThat(game.isPossible).isEqualTo(possible)
    }
}