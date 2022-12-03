package io.github.zodh.adapters.observer;

import org.springframework.context.ApplicationListener;

public abstract class Observer <T extends Observable> implements ApplicationListener<T>, Searchable<T>{

  public T getTarget(Object identifier) {
    if (identifier == null) {
      throw new RuntimeException("It is not possible to get an object with null identifier");
    }
    return peek(identifier);
  }

}
