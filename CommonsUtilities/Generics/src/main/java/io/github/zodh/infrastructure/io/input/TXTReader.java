package io.github.zodh.infrastructure.io.input;

import io.github.zodh.infrastructure.io.FileExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;

public class TXTReader extends FileReader {

  public TXTReader(File file) {
    super(file);
  }

  public TXTReader(String path) {
    super(new File(path));
  }

  public TXTReader() {
  }

  @Override
  protected Boolean isValidFile(File file) {
    return file != null && getFileExtension(file) == FileExtension.TXT;
  }

  @Override
  protected Object read(File file) {
    if (isInvalidFile(file)) {
      throw new IllegalArgumentException("Invalid file. This reader only accepts .txt file");
    }
    try (var fis = new FileInputStream(file)) {
      return new String(fis.readAllBytes(), StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new InputMismatchException("Error trying to read the file.");
    }
  }
}
