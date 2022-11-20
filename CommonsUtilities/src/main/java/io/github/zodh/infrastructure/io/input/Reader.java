package io.github.zodh.infrastructure.io.input;

import java.io.File;

public interface Reader {
  
  Object read(File file);
  
}
