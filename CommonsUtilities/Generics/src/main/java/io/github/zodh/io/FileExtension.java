package io.github.zodh.io;

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

}
