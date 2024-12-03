package aoc.day03;

import aoc.Day;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Day03 implements Day {

    @Override
    public String part1(String input) {
        return getString(input);
    }

    @Override
    public String part2(String input) {
        var corrected = getCorrectedInput(input);
        return getString(corrected);
    }

    @NotNull
    private String getString(String corrected) {
        var pattern = Pattern.compile("(mul\\([0-9]{1,3},[0-9]{1,3}\\))+?");
        var matcher = pattern.matcher(corrected);
        var result = 0;
        while (matcher.find()) {
            var match = matcher.group(1);
            match = match.substring(4, match.length()-1);
            var numbers = match.split(",");
            result += Integer.parseInt(numbers[0])*Integer.parseInt(numbers[1]);
        }
        return result + "";
    }

    private String getCorrectedInput(String input) {
        var splitted = input.split("don't\\(\\)");
        StringBuilder toProcess = new StringBuilder(splitted[0]);
        for(int i=1; i < splitted.length; i++) {
            var toAssert = splitted[i];
            var doIndex = toAssert.indexOf("do()");
            if (doIndex > -1) {
                toProcess.append(toAssert.substring(doIndex));
            } else {
                //System.out.println("not processed = " + toAssert);
            }
        }
        return toProcess.toString();
    }

}
