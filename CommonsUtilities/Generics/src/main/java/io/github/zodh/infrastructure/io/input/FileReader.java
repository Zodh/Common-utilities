package io.github.zodh.infrastructure.io.input;

import io.github.zodh.infrastructure.io.InvalidFileException;
import io.github.zodh.infrastructure.io.file.types.FileData;
import java.io.File;

public abstract class FileReader<T extends FileData> implements Reader<T> {

  protected File file;

  protected FileReader(File file) {
    if (file != null && !file.canRead()) {
      throw new IllegalArgumentException(
          "The input file cannot be read. Make sure you have the necessary permissions to read the file.");
    }
    this.file = file;
  }

  protected FileReader() {
  }

  public T deserializeFileAsObject(final File file) {
    if (file == null) {
      throw new NullPointerException("File is null");
    }
    return read(file);
  }

  public T deserializeFileAsObject(final String path) {
    return deserializeFileAsObject(new File(path));
  }

  public T getDeserializedObject() {
    if (this.file == null) {
      throw new NullPointerException("File was not loaded in Reader constructor");
    }
    if (isInvalidFile(this.file)) {
      throw new InvalidFileException(file);
    }
    return deserializeFileAsObject(this.file);
  }

  protected String getFileName(final File file) {
    return "File name: " + file.getName();
  }

  protected abstract Boolean isValidFile(final File file);

  protected Boolean isInvalidFile(final File file) {
    return !isValidFile(file);
  }

  protected abstract T read(File file);
}
