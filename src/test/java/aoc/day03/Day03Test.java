package aoc.day03;


import aoc.App;
import aoc.Day;
import aoc.day02.Day02;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03Test {

    private String input = """
xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
                """.stripIndent();
    private Day testInstance = new Day03();
    private String testFileName = "day03.txt";
    private String part1InputResult = "161";
    private String part2InputResult = "48";
    private String part1FileInputResult = "183380722";
    private String part2FileInputResult = "82733683";

    @Test
    public void testPart1(){
        // When
        String result = testInstance.part1(input);

        // Then
        assertEquals(part1InputResult, result);
    }

    @Test
    public void testPart2(){
        // When
        String result = testInstance.part2("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))");

        // Then
        assertEquals(part2InputResult, result);
    }

    @Test
    void testWithInputFile(){
        // Given
        var input = App.readClassPathFile(testFileName).orElse("");
        assertThat(input).as("input should not be empty").isNotEmpty();

        // When
        var resultPart1 = testInstance.part1(input);
        var resultPart2 = testInstance.part2(input);

        // Then
        assertThat(resultPart1).isEqualTo(part1FileInputResult);
        assertThat(resultPart2).isEqualTo(part2FileInputResult);
    }
}
