package aoc.day02

import java.util.regex.Pattern
import kotlin.math.abs

class Day02kkotlin {

    private fun isDifferent(a: Int, b: Int): Boolean = abs(a - b) in 1..3

    private fun checkAllFields(line : String): List<Boolean> {
        val report = line.split(Pattern.compile("\\s+"))
            .map { it.toInt() }
        var ascending = false
        return report.mapIndexed { index, value ->
            if (index == 1) {
                ascending = value > report[0]
                isDifferent(report[0], value)
            } else if (index > 1) {
                value > report[index - 1] == ascending && isDifferent(report[index - 1], value)
            } else {
                true
            }
        }
    }

    fun part1(input: String): String {
        return input.lines().map { line ->
                checkAllFields(line).any { v -> !v }
        }.count {v -> !v }.toString()
    }

    fun part2(input: String): String {
        return input.lines().map { line ->
            val fieldCheckResult = checkAllFields(line)
            if (fieldCheckResult.any { v -> !v } ) {
                val report = line.split(Pattern.compile("\\s+"))
                    .map { it.toInt() }
                IntRange(0, report.size-1).map { index ->
                    val reportToTry = report.toMutableList()
                    reportToTry.removeAt(index)
                    checkAllFields(reportToTry.joinToString(" ")).all { it }
                }.any { it }
            } else {
                true
            }
        }.count { it }.toString()
    }



}