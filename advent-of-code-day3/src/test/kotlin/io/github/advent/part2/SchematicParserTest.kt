package io.github.advent.part2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SchematicParserTest {

    @Test
    fun `finds gears`() {
        val schhematic = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...${'$'}.*....
            .664.598..
        """.trimIndent()
        val schematicParser = SchematicParser()
        val gears = schematicParser.parse(schhematic)
        assertThat(gears).containsExactly(
            Gear(
                Part(467), Part(35)
            ),
            Gear(
                Part(755), Part(598)
            )
        )
    }
}