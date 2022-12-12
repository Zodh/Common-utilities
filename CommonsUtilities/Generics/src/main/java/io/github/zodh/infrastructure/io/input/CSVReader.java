package io.github.zodh.infrastructure.io.input;

import static io.github.zodh.infrastructure.io.FileExtension.getFileExtension;

import io.github.zodh.infrastructure.io.FileExtension;
import io.github.zodh.infrastructure.io.file.types.CsvFileData;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

public class CSVReader extends FileReader<CsvFileData> {

  private String delimiter;

  public CSVReader(File file, String delimiter) {
    super(file);
    this.delimiter = delimiter;
  }

  public CSVReader(File file) {
    super(file);
  }

  public CSVReader() {
  }

  @Override
  protected Boolean isValidFile(File file) {
    return getFileExtension(file) == FileExtension.CSV;
  }

  @Override
  protected CsvFileData read(File file) {
    if (StringUtils.isNotBlank(delimiter)) {
      return new CsvFileData(file, delimiter);
    }
    return new CsvFileData(file);
  }

}
