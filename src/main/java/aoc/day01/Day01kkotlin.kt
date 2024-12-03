package aoc.day01

import java.util.regex.Pattern

class Day01kkotlin {

    fun part1(input: String): String {
        return getColumns(input).map { column ->
            column.value.sorted()
        }.zipWithNext { left, right ->
            left.zip(right)
                .sumOf { Math.abs(it.first - it.second) }
                .toString()
        }.first()
    }

    fun part2(input: String): String {
        return getColumns(input).map { column ->
            column.value
        }.zipWithNext { left, right ->
            left.sumOf { right.count { value -> value == it } * it }.toString()
        }.first()
    }

    enum class Column {
        LEFT, RIGHT
    }

    private fun getColumns(input: String): Map<Column, List<Int>> {
        val left = ArrayList<Int>()
        val right = ArrayList<Int>()
        val pattern = Pattern.compile("(\\d+)\\s+(\\d+)")

        input.lines().forEach { line ->
            val matcher = pattern.matcher(line)
            if (matcher.find()) {
                left.add(matcher.group(1).toInt())
                right.add(matcher.group(2).toInt())
            }
        }

        return mapOf(
            Column.LEFT to left,
            Column.RIGHT to right
        )
    }

}