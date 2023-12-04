package io.github.advent.part1

class SchematicParser {
    fun parse(schematic: String) : List<Part> {
        val parts = mutableListOf<Part>()
        val chars = schematic.lines().map { it.toList() }
        chars.forEachIndexed { y, row ->
            row.forEachIndexed { x, char ->
                // is char start of a potential part number
                if (char.isDigit() && ( x == 0 || row[x - 1].isDigit().not())) {
                    var i = x
                    var partNumber = ""
                    var isPart = false
                    while ( i < chars[y].size && chars[y][i].isDigit()) {
                        partNumber+=chars[y][i]
                        if (chars.isNextToSymbol(y, i)) {
                            isPart = true
                        }
                        i++
                    }
                    if (isPart) {
                        parts.add(Part(partNumber.toInt()))
                    }
                }
            }
        }
        return parts
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


data class Part(val number: Int)