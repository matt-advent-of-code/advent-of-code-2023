package io.github.advent.part1

fun main() {
    val cardGame = CardGame()
    CardGame::class.java.getResource("/input.txt")?.readText()?.lines()?.map {
        cardGame.play(it)
    }?.sumOf { it.points }.let {
        println(it)
    }
}