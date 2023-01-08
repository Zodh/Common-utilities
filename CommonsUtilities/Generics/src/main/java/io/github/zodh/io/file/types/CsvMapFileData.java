package io.github.zodh.io.file.types;

import io.github.zodh.io.InvalidFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CsvMapFileData extends CsvFileData {

  private Map<String, String> csvAsMap;

  public CsvMapFileData(File file, String delimiter) {
    super(file, delimiter);
    readCsvDataAsMap();
  }

  public CsvMapFileData(File file) {
    super(file);
    readCsvDataAsMap();
  }

  public Map<String, String> getCsvAsMap() {
    return csvAsMap;
  }

  protected void readCsvDataAsMap() {
    try {
      List<String> records = new ArrayList<>();
      Scanner sc = new Scanner(file);
      sc.useDelimiter(delimiter);
      while (sc.hasNext()) {
        records.add(sc.nextLine());
      }
      sc.close();
      this.csvAsMap = records.stream().collect(Collectors.toMap(
          item -> item.split(";")[0],
          item -> item.split(";")[1])
      );
    } catch (FileNotFoundException fileNotFoundException) {
      throw new InvalidFileException(file, "Error trying to read CSV file as map. " + getName());
    }
  }
}
