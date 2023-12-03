package io.github.advent.part1

class GameParser {

    fun parse(input: String) : Game {
        val rounds = mutableListOf<Round>()
        input.split(";").forEach {
            val red = parseCube(it, "red")
            val blue = parseCube(it, "blue")
            val green = parseCube(it, "green")
            rounds.add(
                Round(
                redCubes = red,
                blueCubes = blue,
                greenCubes = green
            )
            )
        }
        val id = Regex("Game (\\d+):").find(input)!!.groupValues[1]
        return Game(id, rounds)
    }

    private fun parseCube(roundText: String, color: String) : Int {
        Regex("(\\d+) $color").find(roundText).let { matchResult ->
            return matchResult?.let {
                return if (it.groupValues.size == 2) {
                    it.groupValues[1].toInt()
                } else {
                    0
                }
            } ?: 0
        }
    }
}