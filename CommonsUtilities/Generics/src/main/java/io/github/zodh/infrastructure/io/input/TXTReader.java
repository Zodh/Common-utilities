package io.github.zodh.infrastructure.io.input;

import static io.github.zodh.infrastructure.io.FileExtension.getFileExtension;

import io.github.zodh.infrastructure.io.FileExtension;
import io.github.zodh.infrastructure.io.file.types.TextFileData;
import java.io.File;

public class TXTReader extends FileReader<TextFileData> {

  public TXTReader(File file) {
    super(file);
  }

  public TXTReader(String path) {
    super(new File(path));
  }

  public TXTReader() {
  }

  @Override
  protected Boolean isValidFile(File file) {
    return getFileExtension(file) == FileExtension.TXT;
  }

  @Override
  protected TextFileData read(File file) {
    return new TextFileData(file);
  }
}
