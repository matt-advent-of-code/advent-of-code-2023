package io.github.advent.part1

import io.github.advent.part1.Result

class GamePlayer(val maxRed : Int, val maxBlue: Int, val maxGreen: Int) {
    val gameParser = GameParser()

    fun play(input: String) : Result {
        val game = gameParser.parse(input)
        return Result(game, isPossible(game.rounds))
    }

    private fun isPossible(rounds: List<Round>) : Boolean {
        return rounds.maxOf { it.redCubes } <= maxRed &&
                rounds.maxOf { it.blueCubes } <= maxBlue &&
                rounds.maxOf { it.greenCubes } <= maxGreen
    }
}

data class Result(val game: Game, val isPossible: Boolean)