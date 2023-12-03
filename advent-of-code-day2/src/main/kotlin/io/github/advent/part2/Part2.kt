package io.github.advent.part2

fun main() {
    val gamePlayer = GamePlayer()
    GamePlayer::class.java.getResource("/input.txt")?.readText()?.lines()
        ?.map { gamePlayer.play(it) }?.sumOf {
            it.minRed * it.minGreen * it.minBlue
        }.let {
            println(it)
        }
}
