package io.github.zodh.infrastructure.io.output;

public interface Writer <T>{

    void write(T data, final String path);

}
