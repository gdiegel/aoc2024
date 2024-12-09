package io.github.gdiegel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

  private static final Pattern PATTERN = Pattern.compile("do\\(\\).*(mul\\((\\d{1,3}),(\\d{1,3})\\)).*don\\'t\\(\\)");

  public static void main(String[] args) throws IOException, URISyntaxException {
    final URL url = Day03.class.getClassLoader().getResource("input03.txt");
    if (url == null) {
      throw new IllegalStateException();
    }

    final List<String> strings = Files.readAllLines(Path.of(url.toURI()));

    System.out.println(processInstructions(strings));

  }

  public static int processInstructions(final List<String> instructions) {
    int sum = 0;

    for (final String instruction : instructions) {
      sum += parseInstruction(instruction);
    }

    return sum;
  }

  public static int parseInstruction(final String string) {
    int sum = 0;

    final Matcher matcher = PATTERN.matcher(string);
    while (matcher.find()) {
      System.out.println(matcher.group());
      sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
    }

    return sum;
  }
}