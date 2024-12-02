package com.leagueapps;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.leagueapps.Day01.calculateDistanceBetween;
import static com.leagueapps.Day01.calculateSimilarityOf;
import static org.assertj.core.api.Assertions.assertThat;

class Day01Test {

  @Test
  void shouldCalculateDistanceOf11ForExample() {
    final List<Integer> list1 = Arrays.asList(3, 4, 2, 1, 3, 3);
    final List<Integer> list2 = Arrays.asList(4, 3, 5, 3, 9, 3);

    assertThat(calculateDistanceBetween(list1, list2)).isEqualTo(11);
  }

  @Test
  void shouldCalculateSimilarityOf31ForExample() {
    final List<Integer> list1 = Arrays.asList(3, 4, 2, 1, 3, 3);
    final List<Integer> list2 = Arrays.asList(4, 3, 5, 3, 9, 3);

    assertThat(calculateSimilarityOf(list1, list2)).isEqualTo(31);
  }
}