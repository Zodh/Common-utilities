package io.github.zodh.infrastructure.io.file.types;

import io.github.zodh.infrastructure.io.FileExtension;
import java.io.File;

public abstract class FileData {

  protected String name;

  protected String path;

  protected FileExtension fileExtension;

  protected File file;

  protected FileData(File file) {
    this.name = file.getName();
    this.path = file.getAbsolutePath();
    this.fileExtension = FileExtension.getFileExtension(file);
    this.file = file;
  }

  public String getName() {
    return name;
  }

  public String getPath() {
    return path;
  }

  public FileExtension getFileExtension() {
    return fileExtension;
  }

  public File getFile() {
    return file;
  }
}
