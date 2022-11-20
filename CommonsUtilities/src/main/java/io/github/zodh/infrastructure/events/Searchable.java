package io.github.zodh.infrastructure.events;

public interface Searchable <T extends Observable> {

  T peek(Object identifier);

}
