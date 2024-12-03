package aoc.day01

import aoc.App
import aoc.day02.Day02kkotlin
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe


class Day01kkotlinTest: BehaviorSpec({

    given("A fixed test input"){
        val input = """
        3   4
        4   3
        2   5
        1   3
        3   9
        3   3
        """.trimIndent()

        `when`("Part 1 is calculated"){
            val result = Day02kkotlin().part1(input)

            then("Part 1 should return 11") {
                result shouldBe "11"
            }
        }

        `when`("Part 2 is calculated"){
            val result = Day02kkotlin().part2(input)

            then("Part 2 should return 31"){
                result shouldBe "31"
            }
        }
    }

    given("The assignment input file"){
        val input = App.readClassPathFile("day01.txt").orElse("")
        val expectedResul1 = "2113135"
        val expectedResul2 = "19097157"

        input shouldNotBe ""

        `when`("Part 1 is calculated"){
            val result = Day02kkotlin().part1(input)

            then("Part 1 should return 11") {
                result shouldBe expectedResul1
            }
        }

        `when`("Part 2 is calculated"){
            val result = Day02kkotlin().part2(input)

            then("Part 2 should return 31"){
                result shouldBe expectedResul2
            }
        }
    }
})