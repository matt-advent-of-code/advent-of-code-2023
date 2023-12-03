package io.github.advent.part2

import io.github.advent.part1.GameParser

class GamePlayer {

    private val gameParser = GameParser()

    fun play(input: String) : Result {
        val game = gameParser.parse(input)
        return Result(
            minRed = game.rounds.maxOf { it.redCubes },
            minGreen = game.rounds.maxOf { it.greenCubes },
            minBlue = game.rounds.maxOf { it.blueCubes }
        )
    }
}

data class Result(
    val minRed : Int,
    val minBlue: Int,
    val minGreen: Int
)