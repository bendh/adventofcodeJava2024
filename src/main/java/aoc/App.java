/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc;

import aoc.day01.Day01;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URL;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

public class App {

    private static final int year = LocalDate.now().getYear();

    private static final Map<Integer, Day> DAYS;
    static {
        DAYS = new HashMap<>();
        DAYS.put(1, new Day01());
    }

    private static Optional<String> readClassPathFile(String fileName) {
        URL url = ClassLoader.getSystemResource(fileName);
        if(url == null) {
            System.out.println("No file " + fileName + " on the classpath.");
            return Optional.empty();
        }
        Path path = Paths.get(url.getFile());
        if(!Files.exists(path)) {
            return Optional.empty();
        }

        try {
            return Optional.of(Files.readString(path));
        } catch(IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private static String inputFileName(int day) {
        String paddedDay = String.valueOf(day);
        if(day < 10) {
            paddedDay = "0" + day;
        }
        return "day" + paddedDay + ".txt";
    }

    private static String downloadInput(int day, String cookie) {
        String url = String.format("https://adventofcode.com/%d/day/%d/input", year, day);
        URI uri;
        try {
            uri = new URI(url);
        } catch(URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("cookie", cookie.trim())
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        if(response.statusCode() != 200) {
            throw new RuntimeException("Failed to read input from " + url
                + " using cookie " + cookie.substring(0, 5) + "***** ."
                + " Response was " + response.statusCode()
                + " " + response.body());
        }

        String input = response.body();
        try {
            Files.writeString(Paths.get("./src/main/resources/" + inputFileName(day)), input, UTF_8);
        } catch(IOException e) {
            throw new UncheckedIOException(e);
        }
        return input;
    }

    public static void main(String[] args) {
        int day = 1;
        if(args.length != 0){
            day = Integer.parseInt(args[0]);
        }

        int part = 1;
        if(args.length > 1){
            part = Integer.parseInt(args[1]);
        }

        String input = null;

        Optional<String> fileInput = readClassPathFile(inputFileName(day));
        if(fileInput.isPresent()) {
            input = fileInput.get();
        } else {
            Optional<String> cookie = readClassPathFile("session.txt");
            if(cookie.isPresent()) {
                input = downloadInput(day, cookie.get());
            } else {
                System.out.println("Cannot get input for year " + year + " and day " + day + "."
                    + " Either put the input at 'src/main/resources/day[xx].txt"
                    + " or use your browser's network inspector to read the 'cookie' header from the request for"
                    + " input and store it in 'src/main/resources/session.txt' (this file will be ignored by Git).");
                System.exit(1);
            }
        }

        List<String> lines = Arrays.asList(input.split(System.lineSeparator()));

        String result;
        if(part == 1) {
            result = DAYS.get(day).part1(lines);
        } else {
            result = DAYS.get(day).part2(lines);
        }

        System.out.println(result);
    }
}
