package ru.dmsh.otus.matrix.reader.impl;

import ru.dmsh.otus.matrix.reader.MatrixReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MatrixFileReader implements MatrixReader {
    String path;

    public MatrixFileReader(String path) {
        this.path = path;
    }

    @Override
    public String readMatrices() throws IOException {
        File file = new File(getClass().getClassLoader().getResource(path).getFile());
        return Files.readString(Paths.get(file.toURI()));
    }

}
