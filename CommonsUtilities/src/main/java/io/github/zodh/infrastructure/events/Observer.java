package io.github.zodh.infrastructure.events;

import static io.github.zodh.utils.evaluation.ValueEvaluation.isNotNullSafeEval;

import org.springframework.context.ApplicationListener;

public abstract class Observer <T extends Observable> implements ApplicationListener<T>, Searchable<T>{

  public T getTarget(Object identifier) {
    if (identifier == null) {
      throw new RuntimeException("It is not possible to get an object with null identifier");
    }
    T subject = peek(identifier);
    if (Boolean.TRUE.equals(isNotNullSafeEval(subject::getClass)) && subject.getClass().isAnnotationPresent(Identifiable.class)) {
      throw new RuntimeException("It is not possible to get an object without @Identifiable annotation");
    }
    return subject;
  }

}
