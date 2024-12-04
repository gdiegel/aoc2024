package io.github.gdiegel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day02 {

  public static void main(String[] args) throws IOException, URISyntaxException {
    final URL url = Day02.class.getClassLoader().getResource("input02.txt");
    if (url == null) {
      throw new IllegalStateException();
    }

    final List<String> strings = Files.readAllLines(Path.of(url.toURI()));

    final List<List<Integer>> reports = new ArrayList<>();

    for (final String string : strings) {
      final String[] split = string.split("\\s");
      final List<Integer> report = new ArrayList<>();
      for (final String s : split) {
        report.add(Integer.valueOf(s));
      }
      reports.add(report);
    }

    System.out.println(calculateNumberOfSafeReports(reports));
  }

  public static int calculateNumberOfSafeReports(final List<List<Integer>> reports) {
    return (int) reports.stream().filter(Day02::isSafe).count();
  }

  public static boolean isSafe(final List<Integer> report) {
    return isSafe(report, false);
  }

  public static boolean isSafe(final List<Integer> report, boolean isDampened) {
    boolean isSafe = true;

    for (int i = 0; i < report.size(); i++) {
      if (i == 0) continue;
      if (i == report.size() - 1) continue;
      final Integer lastLevel = report.get(i - 1);
      final Integer currentLevel = report.get(i);
      final Integer nextLevel = report.get(i + 1);

      final int diffToLast = Math.abs(currentLevel - lastLevel);
      final int diffToNext = Math.abs(nextLevel - currentLevel);

      if (lastLevel <= currentLevel && nextLevel <= currentLevel) {
        if (isDampened) {
          isSafe = false;
          break;
        } else {
          return tryDampen(new ArrayList<>(report), i - 1) || tryDampen(new ArrayList<>(report), i) || tryDampen(new ArrayList<>(report), i + 1);
        }
      }
      if (lastLevel >= currentLevel && nextLevel >= currentLevel) {
        if (isDampened) {
          isSafe = false;
          break;
        } else {
          return tryDampen(new ArrayList<>(report), i - 1) || tryDampen(new ArrayList<>(report), i) || tryDampen(new ArrayList<>(report), i + 1);
        }
      }
      if (diffToLast < 1 || diffToLast > 3 || diffToNext < 1 || diffToNext > 3) {
        if (isDampened) {
          isSafe = false;
          break;
        } else {
          return tryDampen(new ArrayList<>(report), i - 1) || tryDampen(new ArrayList<>(report), i) || tryDampen(new ArrayList<>(report), i + 1);
        }
      }
    }

    return isSafe;
  }

  private static boolean tryDampen(final List<Integer> report, int i) {
    report.remove(i);
    return isSafe(report, true);
  }
}