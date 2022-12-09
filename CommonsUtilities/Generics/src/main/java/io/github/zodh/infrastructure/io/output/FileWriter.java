package io.github.zodh.infrastructure.io.output;

import org.apache.commons.lang3.StringUtils;

import static io.github.zodh.evaluation.ObjectEvaluator.isNull;

public abstract class FileWriter<T> implements Writer<T> {

    private final T source;

    protected FileWriter(T source) {
        if (isNull(source)) {
            throw new NullPointerException("Source can not be null");
        }
        this.source = source;
    }

    public void postContent(final String path) {
        if (StringUtils.isBlank(path)) {
            throw new IllegalArgumentException("Invalid path");
        }
        if (isInvalidSource(this.source)) {
            throw new IllegalArgumentException("Invalid source");
        }
        write(source, path);
    }

    public abstract Boolean isValidSource(T source);
    public Boolean isInvalidSource(T source) {
        return !isValidSource(source);
    }
}
