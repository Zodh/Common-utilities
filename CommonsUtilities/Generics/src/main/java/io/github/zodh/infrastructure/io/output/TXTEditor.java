package io.github.zodh.infrastructure.io.output;

import io.github.zodh.infrastructure.io.InvalidFileException;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import org.apache.commons.lang3.StringUtils;

public class TXTEditor extends FileEditor<String> {

  public TXTEditor(String content) {
    super(content);
  }

  @Override
  protected Boolean isValidContent(String content) {
    return StringUtils.isNotBlank(content);
  }

  @Override
  protected void write(String data, File file) {
    try (var fileOutputStream = new FileOutputStream(file)) {
      fileOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
    } catch (Exception exception) {
      throw new InvalidFileException(file,
          "Error trying to write in the file. " + exception.getMessage());
    }
  }

}
