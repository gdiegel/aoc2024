package io.github.gdiegel;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day02Test {
  final List<Integer> safeList1 = Lists.newArrayList(7, 6, 4, 2, 1);
  final List<Integer> unsafeList2 = Lists.newArrayList(1, 2, 7, 8, 9);
  final List<Integer> unsafeList3 = Lists.newArrayList(9, 7, 6, 2, 1);
  final List<Integer> unsafeList4 = Lists.newArrayList(1, 3, 2, 4, 5);
  final List<Integer> unsafeList5 = Lists.newArrayList(8, 6, 4, 4, 1);
  final List<Integer> safeList6 = Lists.newArrayList(1, 3, 6, 7, 9);

  @Test
  void shouldReturn4ForExample() {
    final int safeReports = Day02.calculateNumberOfSafeReports(Lists.newArrayList(safeList1, unsafeList2, unsafeList3, unsafeList4, unsafeList5, safeList6));

    assertThat(safeReports).isEqualTo(4);
  }

  @Test
  void shouldReturnTrueForSafeList1() {
    final boolean isSafe = Day02.isSafe(safeList1);

    assertThat(isSafe).isTrue();
  }

  @Test
  void shouldReturnFalseForUnsafeList2() {
    final boolean isSafe = Day02.isSafe(unsafeList2);

    assertThat(isSafe).isFalse();
  }

  @Test
  void shouldReturnFalseForUnsafeList3() {
    final boolean isSafe = Day02.isSafe(unsafeList3);

    assertThat(isSafe).isFalse();
  }

  @Test
  void shouldReturnTrueForUnsafeDampenedList4() {
    final boolean isSafe = Day02.isSafe(unsafeList4);

    assertThat(isSafe).isTrue();
  }

  @Test
  void shouldReturnTrueForUnsafeDampenedList5() {
    final boolean isSafe = Day02.isSafe(unsafeList5);

    assertThat(isSafe).isTrue();
  }

  @Test
  void shouldReturnTrueForSafeList6() {
    final boolean isSafe = Day02.isSafe(safeList6);

    assertThat(isSafe).isTrue();
  }

  @Test
  void shouldReturnTrueForDampenableReport() {
    List<Integer> list = Lists.newArrayList(16, 14, 12, 13, 9);

    final boolean isSafe = Day02.isSafe(list);

    Assertions.assertThat(isSafe).isTrue();
  }
}