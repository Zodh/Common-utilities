package io.github.zodh.io.output;

import io.github.zodh.io.FileExtension;
import io.github.zodh.io.InvalidFileException;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import org.apache.commons.lang3.StringUtils;

public class TXTEditor extends FileEditor<String> {

  public TXTEditor(String content) {
    super(content);
  }

  public TXTEditor() {
    super();
  }

  @Override
  protected Boolean isValidContent(String content) {
    return StringUtils.isNotBlank(content);
  }

  @Override
  protected void write(String data, File file) {
    if (FileExtension.getFileExtension(file) != FileExtension.TXT) {
      throw new InvalidFileException(file, "Invalid file extension. It must be .txt");
    }
    try (var fileOutputStream = new FileOutputStream(file)) {
      fileOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
    } catch (Exception exception) {
      throw new InvalidFileException(file,
          "Error trying to write in the file. " + exception.getMessage());
    }
  }

}
