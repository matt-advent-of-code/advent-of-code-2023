package io.github.advent.part1

fun main() {
    val gamePlayer = GamePlayer(maxRed = 12, maxBlue = 14, maxGreen = 13)
    GamePlayer::class.java.getResource("/input.txt")?.readText()?.lines()
        ?.map { gamePlayer.play(it) }?.filter { it.isPossible }?.sumOf { it.game.id.toInt() }.let {
            println(it)
        }
}