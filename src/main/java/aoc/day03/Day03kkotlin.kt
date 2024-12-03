package aoc.day03

class Day03kkotlin {

    private fun getMulTotal(input: String): Int {
        val regex = """mul\((?<op1>\d{1,3}),(?<op2>\d{1,3})\)""".toRegex()
        return regex.findAll(input).map { matchResult ->
            val op1 = matchResult.groups["op1"]!!.value.toInt()
            val op2 = matchResult.groups["op2"]!!.value.toInt()
            op1 * op2
        }.sum()
    }

    fun part1(input: String): String {
        return getMulTotal(input).toString()
    }

    fun part2(input: String): String {
        return input.split("""don't\(\)""".toRegex())
            .mapIndexed { index, inputPart ->
                if (index == 0) {
                    getMulTotal(inputPart)
                } else {
                    val splitted = inputPart.split(
                        """do\(\)""".toRegex()
                    )
                    splitted.mapIndexed { index, enabled ->
                        if (index == 0) {
                            0
                        } else {
                            getMulTotal(enabled)
                        }
                    }.sum()
                }
            }.sum().toString()
    }


}