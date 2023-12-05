package io.github.advent.part1

import kotlin.math.pow

class CardGame {
    private val cardParser = CardParser()

    fun play(input: String) : GameResult {
        val card = cardParser.parse(input)
        val matchingNumbers = card.cardNumbers.filter { card.winningNumbers.contains(it) }
        val points = when(matchingNumbers.size) {
            0 -> 0
            1 -> 1
            else -> (2).toDouble().pow(matchingNumbers.size - 1).toInt()
        }
        return GameResult(points)
    }
}

data class GameResult(
    val points: Int
)