package com.leagueapps;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day02Test {
  final List<Integer> safeList1 = List.of(7, 6, 4, 2, 1);
  final List<Integer> unsafeList2 = List.of(1, 2, 7, 8, 9);
  final List<Integer> unsafeList3 = List.of(9, 7, 6, 2, 1);
  final List<Integer> unsafeList4 = List.of(1, 3, 2, 4, 5);
  final List<Integer> unsafeList5 = List.of(8, 6, 4, 4, 1);
  final List<Integer> safeList6 = List.of(1, 3, 6, 7, 9);

  @Test
  void shouldReturn2ForExample() {
    final int safeReports = Day02.calculateNumberOfSafeReports(List.of(safeList1, unsafeList2, unsafeList3, unsafeList4, unsafeList5, safeList6));

    assertThat(safeReports).isEqualTo(2);
  }

  @Test
  void shouldReturnTrueForSafeList() {
    final boolean isSafe = Day02.isSafe(safeList1);

    assertThat(isSafe).isTrue();
  }

  @Test
  void shouldReturnFalseForUnSafeList() {
    final boolean isSafe = Day02.isSafe(unsafeList2);

    assertThat(isSafe).isFalse();
  }
}