package aoc.day04

import aoc.App
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe


class Day04kotlinTest: BehaviorSpec({

    val testInstance = Day04kkotlin()
    val testFileName = "day04.txt"
    val part1InputResult = ""
    val part2InputResult = ""
    val part1FileInputResult = ""
    val part2FileInputResult = ""

    given("A fixed test input"){
        val input = """
        """.trimIndent()

        `when`("Part 1 is calculated"){
            val result = testInstance.part1(input)

            then("Part 1 should return 2") {
                result shouldBe part1InputResult
            }
        }

        `when`("Part 2 is calculated"){
            val result = testInstance.part2(input)

            then("Part 2 should return 4"){
                result shouldBe part2InputResult
            }
        }
    }

    given("The assignment input file"){
        val input = App.readClassPathFile(testFileName).orElse("")

        input shouldNotBe ""

        `when`("Part 1 is calculated"){
            val result = testInstance.part1(input)

            then("Part 1 should return 279") {
                result shouldBe part1FileInputResult
            }
        }

        `when`("Part 2 is calculated"){
            val result = testInstance.part2(input)

            then("Part 2 should return 343"){
                result shouldBe part2FileInputResult
            }
        }
    }
})