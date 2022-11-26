package io.github.zodh.evaluation;

import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;

public class ObjectEvaluator {

  private ObjectEvaluator() {

  }

  public static <T> Boolean isNullSafeEval(Supplier<T> function) {
    try {
      return isNull(function.get());
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

  public static <T> Boolean isBlankSafeEval(Supplier<T> function) {
    try {
      return StringUtils.isBlank((String) function.get());
    } catch (Exception exception) {
      return true;
    }
  }

  public static <T> Boolean isNotBlankSafeEval(Supplier<T> function) {
    try {
      return !isBlankSafeEval(function);
    } catch (Exception exception) {
      return false;
    }
  }

}
