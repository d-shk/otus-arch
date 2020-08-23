package ru.dmsh.otus.matrix.multiplication.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.dmsh.otus.matrix.model.Matrix;
import ru.dmsh.otus.matrix.multiplication.IMatrixMultiplicationService;

import static org.junit.jupiter.api.Assertions.*;

class MatrixMultiplicationServiceTest {
    Matrix testMatrix;
    Matrix secondMatrix;

    IMatrixMultiplicationService matrixMultiplicationService;
    @BeforeEach
    void setUp() {
        testMatrix = new Matrix(3,3);
        testMatrix.setElement(1,0,0);
        testMatrix.setElement(2, 0, 1);
        testMatrix.setElement(3, 0, 2);
        testMatrix.setElement(4, 1, 0);
        testMatrix.setElement(5, 1, 1);
        testMatrix.setElement(6, 1, 2);
        testMatrix.setElement(7, 2, 0);
        testMatrix.setElement(8, 2, 1);
        testMatrix.setElement(9, 2, 2);

        secondMatrix = new Matrix(3,4);
        secondMatrix.setElement(1,0,0);
        secondMatrix.setElement(2, 0, 1);
        secondMatrix.setElement(3, 0, 2);
        secondMatrix.setElement(10, 0, 3);
        secondMatrix.setElement(4, 1, 0);
        secondMatrix.setElement(5, 1, 1);
        secondMatrix.setElement(6, 1, 2);
        secondMatrix.setElement(11, 1, 3);
        secondMatrix.setElement(7, 2, 0);
        secondMatrix.setElement(8, 2, 1);
        secondMatrix.setElement(9, 2, 2);
        secondMatrix.setElement(12, 2, 3);

        matrixMultiplicationService = new MatrixMultiplicationService(testMatrix, secondMatrix);
    }

    @Test
    void calculate() {
        int[][] expectedMatrix = {{30, 36, 42, 68}, {66, 81, 96, 167}, {102, 126, 150, 266}};

        assertArrayEquals(expectedMatrix, matrixMultiplicationService.calculate().getMatrix());
    }
}