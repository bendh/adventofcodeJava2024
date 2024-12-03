package aoc.day02;


import aoc.App;
import aoc.Day;
import aoc.day01.Day01;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {

    private String input = """
7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9
                """.stripIndent();
    private Day testInstance = new Day02();
    private String testFileName = "day02.txt";
    private String part1InputResult = "2";
    private String part2InputResult = "4";
    private String part1FileInputResult = "279";
    private String part2FileInputResult = "343";

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
