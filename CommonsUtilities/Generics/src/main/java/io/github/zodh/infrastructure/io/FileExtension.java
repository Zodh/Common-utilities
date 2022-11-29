package io.github.zodh.infrastructure.io;

import java.util.List;

public enum FileExtension {

  CSV(".csv"),
  TXT(".txt");

  private final String fileExtension;

  FileExtension(String fileExtension) {
    this.fileExtension = fileExtension;
  }

  public String getFileExtension() {
    return fileExtension;
  }

  public static FileExtension fromValue(String string) {
    var values = values();
    for (int i = 0; i != values.length; i++) {
      if (values[i].getFileExtension().equals(string)) {
        return values[i];
      }
    }
    throw new IllegalArgumentException("Unhandled file extension");
  }

}
