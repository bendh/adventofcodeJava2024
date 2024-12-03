package aoc.day01;


import aoc.App;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {

    private String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                """;

    @Test
    public void testPart1(){
        // Given
        String expected = "11";

        // When
        String result = new Day01().part1(input);

        // Then
        assertEquals(expected, result);
    }

    @Test
    public void testPart2(){
        // Given
        String expected = "31";

        // When
        String result = new Day01().part2(input);

        // Then
        assertEquals(expected, result);
    }

    @Test
    void testWithInputFile(){
        var expectedResul1 = "2113135";
        var expectedResul2 = "19097157";
        // Given
        var input = App.readClassPathFile("day01.txt").orElse("");
        assertThat(input).as("input should not be empty").isNotEmpty();

        // When
        var resultPart1 = new Day01().part1(input);
        var resultPart2 = new Day01().part2(input);

        // Then
        assertThat(resultPart1).isEqualTo(expectedResul1);
        assertThat(resultPart2).isEqualTo(expectedResul2);
    }
}
