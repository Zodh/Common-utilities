package io.github.zodh.io.output;

import static io.github.zodh.evaluation.ObjectEvaluator.isNull;

import io.github.zodh.io.InvalidFileException;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

public abstract class FileEditor<T> implements Writer<T> {

  private T content;

  protected FileEditor(T content) {
    if (isNull(content)) {
      throw new NullPointerException("Content can not be null");
    }
    this.content = content;
  }

  public FileEditor() {
    this.content = null;
  }

  public FileEditor<T> attachContent(T content) {
    this.content = content;
    return this;
  }

  public void postContentTo(final String path) {
    if (StringUtils.isBlank(path)) {
      throw new IllegalArgumentException("Invalid path");
    }
    postContentTo(new File(path));
  }

  public void postContentTo(File file) {
    if (isInvalidContent(this.content)) {
      throw new IllegalArgumentException("Invalid content");
    }
    if (!file.exists()) {
      throw new InvalidFileException(file, "There is no file on this path");
    }
    write(content, file);
  }

  protected abstract void write(T content, File file);

  protected abstract Boolean isValidContent(T content);

  protected Boolean isInvalidContent(T content) {
    return !isValidContent(content);
  }
}
