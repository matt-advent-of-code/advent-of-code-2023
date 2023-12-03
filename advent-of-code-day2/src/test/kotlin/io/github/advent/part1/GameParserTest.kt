package io.github.advent.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameParserTest {

    @Test
    fun `parses game`() {
        val game = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
        val gameParser = GameParser()
        val rounds = gameParser.parse(game)

        val expected = Game(
            id = "1",
            rounds = listOf(
                Round(blueCubes = 3, redCubes = 4),
                Round(redCubes = 1, greenCubes = 2, blueCubes = 6),
                Round(greenCubes = 2)
            )
        )

        assertThat(rounds).isEqualTo(expected)
    }
}