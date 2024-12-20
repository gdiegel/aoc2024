package io.github.gdiegel;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day03Test {

  @Test
  void shouldReturn48ForExample() {
    final String example = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";

    final int sum = Day03.processInstructions(List.of(example));

    assertThat(sum).isEqualTo(48);
  }
}