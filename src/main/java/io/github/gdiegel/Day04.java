package io.github.gdiegel;

import java.net.URL;

public class Day04 {

  public static void main(String[] args) {
    final URL url = Day04.class.getClassLoader().getResource("input04.txt");
    if (url == null) {
      throw new IllegalStateException();
    }
  }

  public static int findXmas(final String[][] arr) {
    final int total = findInRows("XMAS", arr)
            + findInRows("SAMX", arr)
            + findInColumns("XMAS", arr)
            + findInColumns("SAMX", arr)
            + findDiagonallyLTR("XMAS", arr)
            + findDiagonallyLTR("SAMX", arr)
            + findDiagonallyRTL("XMAS", arr)
            + findDiagonallyRTL("SAMX", arr);

    System.out.printf("TOTAL: %d%n", total);
    return total;
  }

  private static int findInRows(final String word, final String[][] arr) {
    int sum = 0;

    for (String[] strings : arr) {
      for (int j = 0; j < strings.length - 3; j++) {
        if (strings[j].charAt(0) == word.charAt(0)) {
          if (strings[j + 1].charAt(0) == word.charAt(1)) {
            if (strings[j + 2].charAt(0) == word.charAt(2)) {
              if (strings[j + 3].charAt(0) == word.charAt(3)) {
                sum++;
              }
            }
          }
        }
      }
    }
    System.out.printf("Rows: %s: %d%n", word, sum);
    return sum;
  }

  private static int findInColumns(final String word, final String[][] arr) {
    int sum = 0;

    for (int i = 0; i < arr.length - 3; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j].charAt(0) == word.charAt(0)) {
          if (arr[i + 1][j].charAt(0) == word.charAt(1)) {
            if (arr[i + 2][j].charAt(0) == word.charAt(2)) {
              if (arr[i + 3][j].charAt(0) == word.charAt(3)) {
                sum++;
              }
            }
          }
        }
      }
    }

    System.out.printf("Columns: %s: %d%n", word, sum);
    return sum;
  }

  private static int findDiagonallyLTR(final String word, final String[][] arr) {
    int sum = 0;

    for (int i = 0; i < arr.length - 3; i++) {
      for (int j = 0; j < arr[i].length - 3; j++) {
        if (arr[i][j].charAt(0) == word.charAt(0)) {
          if (arr[i + 1][j + 1].charAt(0) == word.charAt(1)) {
            if (arr[i + 2][j + 2].charAt(0) == word.charAt(2)) {
              if (arr[i + 3][j + 3].charAt(0) == word.charAt(3)) {
                sum++;
              }
            }
          }
        }
      }
    }

    System.out.printf("Diagonal LTR: %s: %d%n", word, sum);
    return sum;
  }

  private static int findDiagonallyRTL(final String word, final String[][] arr) {
    int sum = 0;

    for (int i = 3; i < arr.length; i++) {
      for (int j = 3; j < arr[i].length; j++) {
        if (arr[i][j].charAt(0) == word.charAt(0)) {
          if (arr[i - 1][j - 1].charAt(0) == word.charAt(1)) {
            if (arr[i - 2][j - 2].charAt(0) == word.charAt(2)) {
              if (arr[i - 3][j - 3].charAt(0) == word.charAt(3)) {
                sum++;
              }
            }
          }
        }
      }
    }

    System.out.printf("Diagonal RTL: %s: %d%n", word, sum);
    return sum;
  }
}