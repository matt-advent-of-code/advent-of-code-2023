package io.github.advent.part2

class SchematicParser {
    fun parse(schematic: String) : List<Gear> {
        val parts = mutableListOf<Part>()
        val gears = mutableMapOf<Pair<Int, Int>, MutableList<Part>>()
        val chars = schematic.lines().map { it.toList() }
        chars.forEachIndexed { y, row ->
            row.forEachIndexed { x, char ->
                // is char start of a potential part number
                if (char.isDigit() && ( x == 0 || row[x - 1].isDigit().not())) {
                    var i = x
                    var partNumber = ""
                    var isPart = false
                    val adjacentGears = mutableSetOf<Pair<Int, Int>>()
                    while ( i < chars[y].size && chars[y][i].isDigit()) {
                        partNumber+=chars[y][i]
                        if (chars.isNextToSymbol(y, i)) {
                            isPart = true
                        }
                        adjacentGears.addAll(chars.adjacentGears(y, i))
                        i++
                    }
                    if (isPart) {
                        val part = Part(partNumber.toInt())
                        parts.add(part)
                        adjacentGears.forEach { gear ->
                            if (gears.containsKey(gear)) {
                                gears[gear]?.add(part)
                            } else {
                                gears[gear] = mutableListOf(part)
                            }
                        }
                    }
                }
            }
        }
        return gears.filter {
            it.value.size == 2
        }.map { Gear(it.value.first(), it.value.last()) }
    }
}

private fun List<List<Char>>.isNextToSymbol(y: Int, x: Int) : Boolean {
    return isSymbol(y - 1, x - 1) || isSymbol(y - 1, x )
            || isSymbol(y - 1, x + 1) || isSymbol(y , x - 1)
            || isSymbol(y , x ) || isSymbol(y , x + 1) || isSymbol(y + 1 , x - 1)
            || isSymbol(y + 1, x) || isSymbol(y + 1 , x + 1)
}

private fun List<List<Char>>.isSymbol(y: Int, x: Int) : Boolean {
    if (y < 0 || y > size - 1) {
        return false
    }

    if (x < 0 || x > get(y).size - 1) {
        return false
    }

    return isSymbol(get(y)[x])
}

private fun isSymbol(char: Char) = !char.isDigit() && char != '.'



private fun List<List<Char>>.adjacentGears(y: Int, x: Int) : List<Pair<Int, Int>> {
    val gears = mutableListOf<Pair<Int, Int>>()
    if (isGear(y - 1, x - 1)) {
        gears.add(Pair(y - 1, x - 1))
    }

    if (isGear(y - 1, x )) {
        gears.add(Pair(y - 1, x))
    }

    if (isGear(y - 1, x + 1)) {
        gears.add(Pair(y - 1, x + 1))
    }

    if (isGear(y, x - 1)) {
        gears.add(Pair(y, x - 1))
    }

    if (isGear(y, x)) {
        gears.add(Pair(y, x))
    }

    if (isGear(y, x  + 1)) {
        gears.add(Pair(y, x + 1))
    }

    if (isGear(y + 1, x  - 1)) {
        gears.add(Pair(y + 1, x - 1))
    }

    if (isGear(y + 1, x)) {
        gears.add(Pair(y + 1, x))
    }

    if (isGear(y + 1, x + 1)) {
        gears.add(Pair(y + 1, x + 1))
    }

    return gears
}

private fun List<List<Char>>.isGear(y: Int, x: Int) : Boolean {
    if (y < 0 || y > size - 1) {
        return false
    }

    if (x < 0 || x > get(y).size - 1) {
        return false
    }

    return isGear(get(y)[x])
}

private fun isGear(char: Char) = char == '*'



data class Part(val number: Int)

data class Gear(val part1: Part, val part2: Part)