package io.github.zodh.io.input;

import io.github.zodh.io.FileExtension;
import java.io.File;

public abstract class FileReader implements Reader {

  protected File file;

  protected FileReader (File file) {
    if (file != null && !file.canRead()) {
      throw new RuntimeException("The input file cannot be read. Make sure you have the necessary permissions to read the file.");
    }
    this.file = file;
  }

  protected FileReader() {}

  public Object getContent(final File file) {
    if (file == null) {
      throw new NullPointerException("File is null");
    }
    return read(file);
  }

  public Object getContent() {
    if (this.file == null) {
      throw new NullPointerException("File was not loaded in Reader constructor");
    }
    return getContent(this.file);
  }

  protected FileExtension getFileExtension(final File file) {
    if (file == null) {
      throw new NullPointerException("Is not possible to check extension of a null file");
    }
    if (file.getAbsolutePath().contains(FileExtension.CSV.getFileExtension())) {
      return FileExtension.CSV;
    }
    if (file.getAbsolutePath().contains(FileExtension.TXT.getFileExtension())) {
      return FileExtension.TXT;
    }
    throw new RuntimeException("Unhandled file extension");
  }

  protected String getFileName(final File file) {
    return "File name: " + file.getName();
  }

}
