package io.github.zodh.io.file.types;

import io.github.zodh.io.InvalidFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvFileData extends FileData {

  protected static final String ONLY_CSV = "Invalid .CSV file";

  protected String delimiter = ",";

  protected String content;

  protected Integer lines = 0;

  public CsvFileData(File file) {
    super(file);
    readCsvDataAsString();
  }

  public CsvFileData(File file, String delimiter) {
    super(file);
    this.delimiter = delimiter;
    readCsvDataAsString();
  }

  protected void readCsvDataAsString() {
    try {
      StringBuilder sb = new StringBuilder();
      Scanner sc = new Scanner(file);
      sc.useDelimiter(delimiter);
      while (sc.hasNext()) {
        lines++;
        sb.append(sc.next());
      }
      sc.close();
      this.content = sb.toString();
    } catch (FileNotFoundException fileNotFoundException) {
      throw new InvalidFileException(file, ONLY_CSV);
    }
  }

  public String getContent() {
    return content;
  }

  public Integer getLines() {
    return lines;
  }
}
