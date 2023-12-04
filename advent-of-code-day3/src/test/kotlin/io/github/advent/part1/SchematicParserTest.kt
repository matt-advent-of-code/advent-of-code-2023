package io.github.advent.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SchematicParserTest {

    @Test
    fun `parses schematic`() {
        val schematic = """
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
        val parts = schematicParser.parse(schematic)
        assertThat(parts)
            .containsExactly(
                Part(467),
                Part(35),
                Part(633),
                Part(617),
                Part(592),
                Part(755),
                Part(664),
                Part(598)
            )
    }
}