package io.github.zodh.adapters.observer;

public interface Searchable <T extends Observable> {

  T peek(Object identifier);

}
