package io.github.zodh.adapters.observer;

import io.github.zodh.evaluation.ObjectEvaluator;
import org.springframework.context.ApplicationListener;

public abstract class Observer <T extends Observable> implements ApplicationListener<T>, Searchable<T>{

  public T getTarget(Object identifier) {
    if (identifier == null) {
      throw new RuntimeException("It is not possible to get an object with null identifier");
    }
    T subject = peek(identifier);
    if (Boolean.TRUE.equals(ObjectEvaluator.isNotNullSafeEval(subject::getClass)) && subject.getClass().isAnnotationPresent(Identifiable.class)) {
      throw new RuntimeException("It is not possible to get an object without @Identifiable annotation");
    }
    return subject;
  }

}
