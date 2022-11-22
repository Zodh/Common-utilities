package io.github.zodh.observer;

public interface Searchable <T extends Observable> {

  T peek(Object identifier);

}
