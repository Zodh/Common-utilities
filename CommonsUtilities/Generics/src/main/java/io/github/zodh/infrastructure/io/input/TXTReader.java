package io.github.zodh.infrastructure.io.input;

import io.github.zodh.infrastructure.io.FileExtension;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TXTReader extends FileReader {

    @Override
    public Boolean isValidFile(File file) {
        return file != null && getFileExtension(file) == FileExtension.TXT;
    }

    @Override
    public Object read(File file) {
        if (!isValidFile(file)) {
            throw new RuntimeException("Invalid file. This reader only accepts .txt file");
        }
        try (var fis = new FileInputStream(file)){
            return new String(fis.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
