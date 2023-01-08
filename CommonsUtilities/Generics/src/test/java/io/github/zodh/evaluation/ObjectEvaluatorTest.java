package io.github.zodh.evaluation;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.zodh.io.input.CSVMapReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ObjectEvaluatorTest {

  private CSVMapReader csvMapReader;

  @Test
  @DisplayName("Should verify if a declared object is null and returns true")
  void givenNotInstancedObjectWhenVerifyIfThisObjectIsNullThenReturnTrue() {
    // act and assert
    assertThat(ObjectEvaluator.isNull(csvMapReader)).isTrue();
  }

  @Test
  @DisplayName("Should verify if a declared object is null with safe evaluation and returns true")
  void givenNotInstancedObjectWhenVerifyIfMethodReturnIsNullThenReturnTrue() {
    // act and assert
    assertThat(ObjectEvaluator.isNullSafeEval(() -> csvMapReader)).isTrue();
  }

  @Test
  @DisplayName("Should verify if an instanced object is null and returns false")
  void givenInstancedObjectWhenVerifyIfThisObjectIsNullThenReturnFalse() {
    //arrange
    this.csvMapReader = new CSVMapReader();
    // act and assert
    assertThat(ObjectEvaluator.isNull(csvMapReader)).isFalse();
  }

  @Test
  @DisplayName("Should verify if an instanced object is null with safe evaluation and returns false")
  void givenInstancedObjectWhenVerifyIfMethodReturnIsNullThenReturnFalse() {
    //arrange
    this.csvMapReader = new CSVMapReader();
    // act and assert
    assertThat(ObjectEvaluator.isNullSafeEval(() -> csvMapReader)).isFalse();
  }

  @Test
  @DisplayName("Should verify if a declared object is not null null and returns false")
  void givenNotInstancedObjectWhenVerifyIfThisObjectIsNotNullThenReturnFalse() {
    // act and assert
    assertThat(ObjectEvaluator.isNotNull(csvMapReader)).isFalse();
  }

  @Test
  @DisplayName("Should verify if a declared is not null with safe evaluation and returns false")
  void givenNotInstancedObjectWhenVerifyIfMethodReturnIsNotNullThenReturnFalse() {
    // act and assert
    assertThat(ObjectEvaluator.isNotNullSafeEval(() -> csvMapReader)).isFalse();
  }

  @Test
  @DisplayName("Should verify if an instanced object is not null and returns true")
  void givenInstancedObjectWhenVerifyIfThisObjectIsNotNullThenReturnTrue() {
    //arrange
    this.csvMapReader = new CSVMapReader();
    // act and assert
    assertThat(ObjectEvaluator.isNotNull(csvMapReader)).isTrue();
  }

  @Test
  @DisplayName("Should verify if an instanced object is not null with safe evaluation and returns true")
  void givenInstancedObjectWhenVerifyIfMethodReturnIsNotNullThenReturnTrue() {
    //arrange
    this.csvMapReader = new CSVMapReader();
    // act and assert
    assertThat(ObjectEvaluator.isNotNullSafeEval(() -> csvMapReader)).isTrue();
  }

  @Test
  @DisplayName("Should verify if string is empty and return true (safe evaluation)")
  void givenEmptyStringWhenVerifyIfIsBlankSafeEvalThenReturnTrue() {
    // act and assert
    assertThat(ObjectEvaluator.isBlankSafeEval(() -> "   ")).isTrue();
  }

  @Test
  @DisplayName("Should verify if string is null and return true (safe evaluation)")
  void givenNullWhenVerifyIfIsBlankSafeEvalThenReturnTrue() {
    // act and assert
    assertThat(ObjectEvaluator.isBlankSafeEval(() -> null)).isTrue();
  }

  @Test
  @DisplayName("Should verify if string is only whitespaces and return true (safe evaluation)")
  void givenStringWithWhitespaceOnlyWhenVerifyIfIsBlankSafeEvalThenReturnTrue() {
    // act and assert
    assertThat(ObjectEvaluator.isBlankSafeEval(() -> "   ")).isTrue();
  }

  @Test
  @DisplayName("Should verify if string is not empty and return true (safe evaluation)")
  void givenNotEmptyStringWhenVerifyIfIsBlankSafeEvalThenReturnTrue() {
    // act and assert
    assertThat(ObjectEvaluator.isNotBlankSafeEval(() -> "s")).isTrue();
  }

  @Test
  @DisplayName("Should verify if string is not only whitespaces and return false (safe evaluation)")
  void givenStringWithWhitespaceOnlyWhenVerifyIfIsNotBlankSafeEvalThenReturnTrue() {
    // act and assert
    assertThat(ObjectEvaluator.isNotBlankSafeEval(() -> "   ")).isFalse();
  }


}
