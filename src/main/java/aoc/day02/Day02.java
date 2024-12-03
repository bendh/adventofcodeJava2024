package aoc.day02;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day02 implements Day {

    @Override
    public String part1(String input) {
        return input.lines()
                .map(line -> line.split("\\s"))
                .filter(splittedLine -> splittedLine.length > 1)
                .map(strings -> Arrays.stream(strings).mapToInt(Integer::parseInt).toArray())
                .map(report -> isSafe(report).isEmpty())
                .filter(valid -> valid)
                .count() + "";
    }

    @Override
    public String part2(String input) {
        return input.lines()
                .map(line -> line.split("\\s"))
                .filter(splittedLine -> splittedLine.length > 1)
                .map(strings -> Arrays.stream(strings).mapToInt(Integer::parseInt).toArray())
                .map(report -> {
                    var isSafe = isSafe(report);
                    if(isSafe.isEmpty()) {
                        return true;
                    } else {
                        return IntStream.range(0, report.length)
                                .mapToObj(index -> isSafe(getCorrectedReport(report, index)).isEmpty())
                                .anyMatch(isValid -> isValid);
                    }
                })
                .filter(valid -> valid)
                .count() + "";
    }

    private int[] getCorrectedReport(int[] report, int toRemove) {
        var correctedReport = new int[report.length - 1];
        for(int i = 0, j = 0; i < report.length; i++) {
            if(i != toRemove) {
                correctedReport[j++] = report[i];
            }
        }
        return correctedReport;
    }

    private ArrayList<Integer> isSafe(int[] report) {
        var isEqual = (BiFunction<Integer, Integer, Boolean>) (a, b) -> {
            var difference = Math.abs(a - b);
            return difference == 0 || difference > 3 ;
        };
        var isNotIncrementingAsPrevious = (BiFunction<Boolean, Boolean, Boolean>) (a, b) -> a != b;
        var increasing = true;
        var wrongIndexes = new ArrayList<Integer>();
        for(int i = 1; i < report.length; i++) {
            var value = report[i];
            var previous = report[i - 1];
            var increment =  value > previous;
            if (i == 1) {
                increasing = increment;
            }
            if (isEqual.apply(value, previous) || isNotIncrementingAsPrevious.apply(increasing, increment)){
                wrongIndexes.add(i);
            }
        }
        return wrongIndexes;
    }

}
