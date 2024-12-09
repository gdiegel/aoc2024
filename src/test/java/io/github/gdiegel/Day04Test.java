package io.github.gdiegel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day04Test {

  @Test
  void shouldReturn18ForExample() {
    final String[] input = {
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
    };

    // Convert the input to a 2D array
    String[][] arr = new String[input.length][];
    for (int i = 0; i < input.length; i++) {
      arr[i] = input[i].split("");
    }

    final int total = Day04.findXmas(arr);

    assertThat(total).isEqualTo(18);
  }
}