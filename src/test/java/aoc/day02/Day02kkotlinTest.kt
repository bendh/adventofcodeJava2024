package aoc.day02

import aoc.App
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe


class Day02kkotlinTest: BehaviorSpec({

    given("A fixed test input"){
        val input = """
7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9
        """.trimIndent()

        `when`("Part 1 is calculated"){
            val result = Day02kkotlin().part1(input)

            then("Part 1 should return 2") {
                result shouldBe "2"
            }
        }

        `when`("Part 2 is calculated"){
            val result = Day02kkotlin().part2(input)

            then("Part 2 should return 4"){
                result shouldBe "4"
            }
        }
    }

    given("The assignment input file"){
        val input = App.readClassPathFile("day02.txt").orElse("")
        val expectedResul1 = "279"
        val expectedResul2 = "343"

        input shouldNotBe ""

        `when`("Part 1 is calculated"){
            val result = Day02kkotlin().part1(input)

            then("Part 1 should return 279") {
                result shouldBe expectedResul1
            }
        }

        `when`("Part 2 is calculated"){
            val result = Day02kkotlin().part2(input)

            then("Part 2 should return 343"){
                result shouldBe expectedResul2
            }
        }
    }
})