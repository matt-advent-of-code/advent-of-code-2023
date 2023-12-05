package io.github.advent.part1

class CardParser {
    fun parse(input: String) : Card {
        val id = Regex("Card\\s+(\\d+):").find(input).let {
            it!!.groupValues[1]
        }.toInt()

        val winningNumbers = input.replaceBefore(":", "").replace(":", "").split("|")
            .first().split(Regex("\\s+")).filter { it.isNotBlank() }.map { it.toInt() }

        val cardNumbers = input.replaceBefore(":", "").replace(":", "").split("|")[1]
            .split(Regex("\\s+")).filter { it.isNotBlank() }.map { it.toInt() }

        return Card(id, winningNumbers, cardNumbers)
    }
}

data class Card(
    val id: Int,
    val winningNumbers : List<Int>,
    val cardNumbers : List<Int>
)