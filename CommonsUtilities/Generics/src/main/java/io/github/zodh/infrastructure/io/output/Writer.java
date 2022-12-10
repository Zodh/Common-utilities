package io.github.zodh.infrastructure.io.output;

import java.io.IOException;

public interface Writer <T>{

    void write(T data, final String path);

    void append(T data, final String path);

}
