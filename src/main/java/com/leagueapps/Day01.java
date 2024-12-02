package com.leagueapps;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Day01 {

  public static void main(String[] args) throws IOException, URISyntaxException {
    final URL url = Day01.class.getClassLoader().getResource("input01.txt");
    if (url == null) {
      throw new IllegalStateException();
    }

    final List<String> strings = Files.readAllLines(Path.of(url.toURI()));

    final ArrayList<Integer> list1 = new ArrayList<>();
    final ArrayList<Integer> list2 = new ArrayList<>();

    for (final String string : strings) {
      final String[] split = string.split("\\s");
      list1.add(Integer.valueOf(split[0]));
      list2.add(Integer.valueOf(split[split.length - 1]));
    }

    System.out.println(calculateDistanceBetween(list1, list2));
    System.out.println(calculateSimilarityOf(list1, list2));
  }

  public static int calculateDistanceBetween(final List<Integer> list1, final List<Integer> list2) {
    int distance = 0;

    list1.sort(Comparator.naturalOrder());
    list2.sort(Comparator.naturalOrder());

    for (int i = 0; i < list1.size(); i++) {
      distance += Math.abs(list1.get(i) - list2.get(i));
    }

    return distance;
  }

  public static int calculateSimilarityOf(final List<Integer> list1, final List<Integer> list2) {
    int similarity = 0;

    for (final Integer num : list1) {
      final long count = list2.stream().filter(integer -> Objects.equals(integer, num)).count();
      similarity += (int) (num * count);
    }

    return similarity;
  }
}