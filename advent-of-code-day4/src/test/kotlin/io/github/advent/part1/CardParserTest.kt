package io.github.advent.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CardParserTest {

    @ParameterizedTest
    @MethodSource("args")
    fun `parses cards`(input: String, expected: Card) {
        val cardParser = CardParser()
        val card = cardParser.parse(input)
        assertThat(card).isEqualTo(expected)
    }


    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53", Card(1, listOf(41, 48, 83, 86, 17), listOf(83, 86, 6, 31, 17, 9, 48, 53))),
            Arguments.of("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19", Card(2, listOf(13, 32, 20, 16, 61), listOf(61, 30, 68, 82, 17, 32, 24, 19)))
        )
    }

}