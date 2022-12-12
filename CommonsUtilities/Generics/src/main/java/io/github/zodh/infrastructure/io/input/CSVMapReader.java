package io.github.zodh.infrastructure.io.input;

import static io.github.zodh.infrastructure.io.FileExtension.getFileExtension;

import io.github.zodh.infrastructure.io.FileExtension;
import io.github.zodh.infrastructure.io.file.types.CsvMapFileData;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

public class CSVMapReader extends FileReader<CsvMapFileData> {

  private String delimiter;

  public CSVMapReader(File file, String delimiter) {
    super(file);
    this.delimiter = delimiter;
  }

  public CSVMapReader(File file) {
    super(file);
  }

  public CSVMapReader() {
  }

  @Override
  protected Boolean isValidFile(File file) {
    return getFileExtension(file) == FileExtension.CSV;
  }

  @Override
  protected CsvMapFileData read(File file) {
    if (StringUtils.isNotBlank(delimiter)) {
      return new CsvMapFileData(file, delimiter);
    }
    return new CsvMapFileData(file);
  }

}
