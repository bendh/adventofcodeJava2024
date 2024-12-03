package aoc;


import aoc.day01.Day01;
import aoc.day02.Day02;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class AllDaysTest {

    private static Stream<Arguments> getTestInput() {
        return Stream.of(
                Arguments.of("Day 1 tests",
                        """
                                3   4
                                4   3
                                2   5
                                1   3
                                3   9
                                3   3
                                """, new Day01(), "day01.txt", List.of("11", "31", "2113135", "19097157")),
                Arguments.of("Day 2 tests",
                        """
                        7 6 4 2 1
                        1 2 7 8 9
                        9 7 6 2 1
                        1 3 2 4 5
                        8 6 4 4 1
                        1 3 6 7 9
                                """.stripIndent(), new Day02(), "day02.txt", List.of("2", "", "", ""))
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("getTestInput")
    void testPart1(String test, String input, Day testInstance, String inputFileName, List<String> expectedResults) {
        var fileInput = App.readClassPathFile(inputFileName).orElse("");
        assertThat(fileInput).as("input should not be empty: " + inputFileName).isNotEmpty();

        // When
        var testInputResultPart1 = testInstance.part1(input);
        var testInputResultPart2 = testInstance.part2(input);
        var fileInputResultPart1 = testInstance.part1(fileInput);
        var fileInputResultPart2 = testInstance.part2(fileInput);

        // Then
        assertThat(testInputResultPart1)
                .as("part 1 testInput test failed")
                .isEqualTo(expectedResults.get(0));
        assertThat(testInputResultPart2)
                .as("part 2 testInput test failed")
                .isEqualTo(expectedResults.get(1));
        assertThat(fileInputResultPart1)
                .as("part 1 fileInput test failed")
                .isEqualTo(expectedResults.get(2));
        assertThat(fileInputResultPart2)
                .as("part 2 fileInput test failed")
                .isEqualTo(expectedResults.get(3));
    }
}
