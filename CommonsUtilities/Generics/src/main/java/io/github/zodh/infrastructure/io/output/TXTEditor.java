package io.github.zodh.infrastructure.io.output;

import io.github.zodh.infrastructure.io.InvalidFileException;

import java.io.File;
import java.io.FileWriter;

public class TXTEditor extends FileEditor<String> {


    protected TXTEditor(String source) {
        super(source);
    }

    @Override
    public Boolean isValidSource(String source) {
        return null;
    }

    @Override
    public void write(String data, String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new InvalidFileException(file, "There is no file on this path");
        }
        try {
            var fw = new FileWriter(file);

        } catch (Exception exception) {
            throw new RuntimeException("Error trying to write in the file. " + exception.getMessage());
        }
    }

    @Override
    public void append(String data, String path) {

    }
}
