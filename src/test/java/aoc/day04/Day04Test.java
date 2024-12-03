package aoc.day04;


import aoc.App;
import aoc.Day;
import aoc.day03.Day03;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day04Test {

    private String input = """

                """.stripIndent();
    private Day testInstance = new Day04();
    private String testFileName = "day04.txt";
    private String part1InputResult = "?";
    private String part2InputResult = "?";
    private String part1FileInputResult = "?";
    private String part2FileInputResult = "?";

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
        String result = testInstance.part2(input);

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
