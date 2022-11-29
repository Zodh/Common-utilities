package io.github.zodh.infrastructure.io.input;

import io.github.zodh.infrastructure.io.FileExtension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader extends FileReader {

  protected static final String ONLY_CSV = "This reader only accepts .CSV files";

  protected String delimiter = ",";

  public CSVReader(File file) {
    super(file);
    checkIfIsValidCSVFile(file);
  }

  public CSVReader(File file, String customDelimiter) {
    super(file);
    checkIfIsValidCSVFile(file);
    this.delimiter = customDelimiter;
  }

  public CSVReader() {}

  @Override
  public Boolean isValidFile(File file) {
    return file != null && getFileExtension(file) == FileExtension.CSV;
  }

  @Override
  public Object read(File file) {
    checkIfIsValidCSVFile(file);
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

  protected void checkIfIsValidCSVFile(final File file) {
    if (Boolean.TRUE.equals(isInvalidFile(file))) {
      throw new RuntimeException(ONLY_CSV);
    }
  }

}
