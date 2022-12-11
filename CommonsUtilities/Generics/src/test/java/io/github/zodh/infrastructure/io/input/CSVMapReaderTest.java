package io.github.zodh.infrastructure.io.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CSVMapReaderTest {

  private CSVReader csvReader;

  @BeforeEach
  void init() {
    this.csvReader = new CSVMapReader();
  }

  @Test
  @DisplayName("Should read a CSV file as map")
  void givenCSVFileWhenCallReadCsvAsMapMethodThenReturnFileContentAsMap() {
    final File file = new File("src\\test\\resources\\teste.csv");
    Map<String, String> content = (HashMap<String, String>) csvReader.getContentFrom(file);
    assertThat(content).containsKey("felipec");
    assertThat(content.get("felipec")).isEqualTo("author");
  }

  @Test
  @DisplayName("Should not read TXT File and should throws exception")
  void givenTXTFileWhenCallReadMethodThenThrowsException() {
    final File file = new File("src\\test\\resources\\teste.txt");
    assertThrows(RuntimeException.class, () -> csvReader.read(file));
  }

}
