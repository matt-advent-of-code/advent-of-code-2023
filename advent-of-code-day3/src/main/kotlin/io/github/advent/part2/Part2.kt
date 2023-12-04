package io.github.advent.part2


fun main() {
    val schematicParser = SchematicParser()
    val schematic = SchematicParser::class.java.getResource("/input.txt")?.readText() ?: ""
    val parts = schematicParser.parse(schematic)
    println(parts.sumOf { it.part1.number * it.part2.number })
}