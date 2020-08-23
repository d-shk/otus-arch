package ru.dmsh.otus;

import ru.dmsh.otus.matrix.model.Matrix;
import ru.dmsh.otus.matrix.multiplication.impl.MatrixConcurrentMultiplicationService;
import ru.dmsh.otus.matrix.reader.*;
import ru.dmsh.otus.matrix.reader.impl.MatrixFileReader;
import ru.dmsh.otus.matrix.reader.impl.MatrixParserImpl;
import ru.dmsh.otus.matrix.reader.impl.MatrixPrinterImpl;

import java.io.*;
import java.util.List;
import java.util.Random;

public class Application {
    private static final String TEST_MATRIX =
            "1 2 3\n" +
            "4 5 6\n" +
            "7 8 9\n" +
            "-----\n" +
            "5 4 0\n" +
            "3 2 1\n" +
            "8 9 0";
/* Result matrix for test data:
    35	35	2
    83	80	5
    131	125	8
 */
    static volatile Matrix resultMatrix;
    static Matrix A;
    static Matrix B;

    private static void randomMatrix(final Matrix matrix)
    {
        final Random random = new Random();

        for (int row = 0; row < matrix.getRowNum(); row++)
            for (int col = 0; col < matrix.getColNum(); col++)
                matrix.setElement(random.nextInt(100), row, col);
    }

    public static void main(String[] args) throws IOException {
        MatrixParser parser = new MatrixParserImpl();
        MatrixPrinter printer = new MatrixPrinterImpl();
        MatrixFileReader reader = new MatrixFileReader("test-matrix");
        String matricesFromFile = reader.readMatrices();
        List<Matrix> matrices = parser.parse(matricesFromFile, "-----");

        A = matrices.get(0);
        B = matrices.get(1);

        resultMatrix = A.multiplication(B);

        printer.print(resultMatrix);

        Matrix A1 = new Matrix(1000, 1000);
        Matrix B1 = new Matrix(1000, 1000);

        randomMatrix(A1);
        randomMatrix(B1);

        MatrixConcurrentMultiplicationService matrixConcurrentMultiplication =
                new MatrixConcurrentMultiplicationService(A1, B1,5);
        Matrix result = matrixConcurrentMultiplication.calculate();

        //printer.print(result);
    }


}
