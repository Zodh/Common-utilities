package io.github.zodh.infrastructure.io.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TXTReaderTest {

  private FileReader txtReader;

  @BeforeEach
  void init() {
    this.txtReader = new TXTReader();
  }

  @Test
  @DisplayName("Should read a TXT file")
  void givenCSVFileWhenCallReadMethodThenReturnFileContent() {
    final File file = new File("src/test/resources/teste.txt");
    String content = (String) txtReader.getContentFrom(file);
    assertThat(content).isEqualTo("felipec;author");
  }

  @Test
  @DisplayName("Should not read CSV File and should throws exception")
  void givenTXTFileWhenCallReadMethodThenThrowsException() {
    final File file = new File("src/test/resources/teste.csv");
    var exc = assertThrows(RuntimeException.class, () -> txtReader.read(file));
    System.out.println(exc.getMessage());
  }

}
