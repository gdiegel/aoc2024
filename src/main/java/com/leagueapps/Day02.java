package com.leagueapps;

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
    boolean isSafe = true;

    for (int i = 0; i < report.size(); i++) {
      if (i == 0) continue;
      final Integer current = report.get(i);
      final Integer last = report.get(i - 1);

      final int diff = Math.abs(current - last);
      if (diff < 1 || diff > 3) {
        isSafe = false;
        break;
      }

      if (report.get(1) > report.get(0)) {
        // Increasing
        if (current < last) {
          isSafe = false;
          break;
        }
      } else {
        // Decreasing
        if (current > report.get(i - 1)) {
          isSafe = false;
          break;
        }
      }
    }

    return isSafe;
  }
}