package io.github.advent.part1

fun main() {
    val schematicParser = SchematicParser()
    val schematic = SchematicParser::class.java.getResource("/input.txt")?.readText() ?: ""
    val parts = schematicParser.parse(schematic)
    println(parts.sumOf { it.number })
}