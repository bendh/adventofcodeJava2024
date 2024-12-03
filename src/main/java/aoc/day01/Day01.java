package aoc.day01;

import aoc.Day;
import aoc.Utils;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Day01 implements Day {

    @Override
    public String part1(String input) {
        var columns = getNumbers(input);
        var left = columns.get(Column.LEFT);
        var right = columns.get(Column.RIGHT);
        left.sort(Integer::compareTo);
        right.sort(Integer::compareTo);
        var sum = IntStream.range(0, left.size())
                .map(i -> Math.abs(left.get(i) - right.get(i)))
                .sum();
        return ""+sum;
    }

    @Override
    public String part2(String input) {
        var columns = getNumbers(input);
        var left = columns.get(Column.LEFT);
        var right = columns.get(Column.RIGHT);
        var sum = IntStream.range(0, left.size())
                .map(i -> {
                    var leftValue = left.get(i);
                    var occurence = right.stream()
                            .filter(rightValue -> rightValue.equals(leftValue))
                            .mapToInt(integer -> 1)
                            .sum();
                    return leftValue * occurence;
                })
                .sum();
        return ""+sum;
    }

    private EnumMap<Column, List<Integer>> getNumbers(String input) {
        List<String> lines = Utils.splitLines(input);
        var listSize = lines.size();
        List<Integer> left = new ArrayList<>(listSize);
        List<Integer> right = new ArrayList<>(listSize);
        var pattern = Pattern.compile("(\\d+)\\s+(\\d+)");
        lines.forEach(line ->{
            var matcher = pattern.matcher(line);
            if (matcher.find()) {
                left.add(Integer.parseInt(matcher.group(1)));
                right.add(Integer.parseInt(matcher.group(2)));
            }
        });
        EnumMap<Column, List<Integer>> columns = new EnumMap<>(Column.class);
        columns.put(Column.LEFT, left);
        columns.put(Column.RIGHT, right);
        return columns;
    }

    public enum Column {
        LEFT, RIGHT
    }

}
