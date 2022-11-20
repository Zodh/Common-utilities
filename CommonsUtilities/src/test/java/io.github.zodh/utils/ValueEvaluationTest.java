package io.github.zodh.utils;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.zodh.utils.evaluation.ValueEvaluation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ValueEvaluationTest {

  @Nested
  class IsBlankSafeEval {

    @Test
    @DisplayName("When the isBlankSafeEval receives a valid String, the method should returns False")
    void given_String_when_StringIsValid_then_ShouldReturnFalse() {
      // arrange
      var value = "foobar";

      // act
      var result = ValueEvaluation.isBlankSafeEval(() -> value);

      // assert
      assertThat(result).isFalse();
    }

    @Test
    @DisplayName("When the isBlankSafeEval receives an invalid String, the method should returns True")
    void given_String_when_StringIsInvalid_then_ShouldReturnTrue() {
      // arrange and act
      var result = ValueEvaluation.isBlankSafeEval(() -> null);

      // assert
      assertThat(result).isTrue();
    }

  }

}
