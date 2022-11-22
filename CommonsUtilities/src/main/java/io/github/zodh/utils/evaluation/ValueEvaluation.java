package io.github.zodh.utils.evaluation;

import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;

public class ValueEvaluation {

  private ValueEvaluation() {

  }

  public static <T> Boolean isNullSafeEval(Supplier<T> function) {
    try {
      return function.get() == null;
    } catch (NullPointerException exception) {
      return true;
    }
  }

  public static <T> Boolean isNull(T object) {
    return object == null;
  }

  public static <T> Boolean isNotNullSafeEval(Supplier<T> function) {
    return !isNullSafeEval(function);
  }

  public static <T> Boolean isNotNull(T object) {
    return !isNull(object);
  }

  public static <T> Boolean nonNullSafeEval(Supplier<T> function) {
    try {
      return !isNullSafeEval(function);
    } catch (NullPointerException exception) {
      return false;
    }
  }

  public static <T> Boolean isBlankSafeEval(Supplier<T> function) {
    try {
      return StringUtils.isBlank((String) function.get());
    } catch (Exception exception) {
      return true;
    }
  }

  public static Boolean isBlank(String value) {
    return StringUtils.isBlank(value);
  }

  public static <T> Boolean isNotBlankSafeEval(Supplier<T> function) {
    try {
      return !isBlankSafeEval(function);
    } catch (Exception exception) {
      return false;
    }
  }

  public static Boolean isNotBlank(String value) {
    return StringUtils.isNotBlank(value);
  }

}
