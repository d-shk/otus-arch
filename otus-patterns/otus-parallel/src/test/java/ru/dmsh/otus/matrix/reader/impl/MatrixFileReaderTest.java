package ru.dmsh.otus.matrix.reader.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.dmsh.otus.matrix.reader.MatrixReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MatrixFileReaderTest {

    final String expectedResult= "1 2 3\n" +
            "4 5 6\n" +
            "7 8 9\n" +
            "-----\n" +
            "5 4 0\n" +
            "3 2 1\n" +
            "8 9 0";

    MatrixReader matrixReader;

    @Test
    void readMatrices() throws IOException {
        matrixReader = new MatrixFileReader("test-matrix");

        String result = matrixReader.readMatrices();
        assertEquals(expectedResult, result);
    }

    @Test
    void readMatrices_missedFile() throws IOException {
        matrixReader = new MatrixFileReader("fail_file");
        assertThrows(NullPointerException.class, () -> matrixReader.readMatrices());
    }
}