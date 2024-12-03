package aoc.day03

import aoc.App
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe


class Day03kotlinTest: BehaviorSpec({

    val testInstance = Day03kkotlin()
    val testFileName = "day03.txt"
    val part1InputResult = "161"
    val part2InputResult = "48"
    val part1FileInputResult = "183380722"
    val part2FileInputResult = "82733683"

    given("A fixed test input"){
        val input = """
        xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
        """.trimIndent()

        `when`("Part 1 is calculated"){
            val result = testInstance.part1(input)

            then("Part 1 should return 2") {
                result shouldBe part1InputResult
            }
        }

        `when`("Part 2 is calculated"){
            val result = testInstance.part2("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")

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