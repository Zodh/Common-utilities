package io.github.zodh.infrastructure.io.input;

import io.github.zodh.infrastructure.io.FileExtension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader extends FileReader {

  protected String delimiter = ",";

  public CSVReader(File file) {
    super(file);
    checkIfFileIsACSV();
  }

  public CSVReader(File file, String customDelimiter) {
    super(file);
    checkIfFileIsACSV();
    this.delimiter = customDelimiter;
  }

  public CSVReader() {}

  @Override
  public Object read(File file) {
    try {
      StringBuilder sb = new StringBuilder();
      Scanner sc = new Scanner(file);
      sc.useDelimiter(delimiter);
      while (sc.hasNext()) {
        sb.append(sc.next());
      }
      sc.close();
      return sb.toString();
    } catch (FileNotFoundException fileNotFoundException) {
      throw new RuntimeException("Error trying to read CSV file. " + getFileName(file));
    }
  }

  private void checkIfFileIsACSV() {
    if (file != null && getFileExtension(file) != FileExtension.CSV) {
      throw new RuntimeException("File extension is not CSV. " + getFileName(file));
    }
  }

}
