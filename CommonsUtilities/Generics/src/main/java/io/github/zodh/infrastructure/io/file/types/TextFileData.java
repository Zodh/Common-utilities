package io.github.zodh.infrastructure.io.file.types;

import io.github.zodh.infrastructure.io.InvalidFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TextFileData extends FileData {

  private String content;

  public TextFileData(File file) {
    super(file);
    readTextFileContent();
  }

  public String getContent() {
    return content;
  }

  public Integer getLines() {
    String[] lines = this.content.split("\r\n|\r|\n");
    return lines.length;
  }

  public Integer getCharCount() {
    return this.content.length();
  }

  private void readTextFileContent() {
    try (var fis = new FileInputStream(this.file)) {
      this.content = new String(fis.readAllBytes(), StandardCharsets.UTF_8);
    } catch (IOException exception) {
      throw new InvalidFileException(this.file, "Error trying to read this text file");
    }
  }
}
