package io.github.zodh.infrastructure.io.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CSVMapReader extends CSVReader {

  public CSVMapReader(File file) {
    super(file);
  }

  public CSVMapReader(File file, String customDelimiter) {
    super(file, customDelimiter);
  }

  public CSVMapReader() {
  }

  @Override
  protected Map<String, String> read(File file) {
    checkIfIsValidCSVFile(file);
    try {
      List<String> records = new ArrayList<>();
      Scanner sc = new Scanner(file);
      sc.useDelimiter(delimiter);
      while (sc.hasNext()) {
        records.add(sc.nextLine());
      }
      sc.close();
      return records.stream().collect(Collectors.toMap(
          item -> item.split(";")[0],
          item -> item.split(";")[1])
      );
    } catch (FileNotFoundException fileNotFoundException) {
      throw new RuntimeException("Error trying to read CSV file as map. " + getFileName(file));
    }
  }

}
