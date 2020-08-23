package ru.dmsh.otus.matrix.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    Matrix testMatrix;
    Matrix secondMatrix;

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
    }

    @Test
    void setElement() {
        testMatrix.setElement(1, 2, 2);
        assertEquals(testMatrix.getElement(2, 2), 1);
    }

    @Test
    void setElement_incorrectIndex() {
        Throwable throwable = assertThrows(IndexOutOfBoundsException.class, () ->
                testMatrix.setElement(900, 5, 6)
                );
        assertNotNull(throwable);
    }

    //30  36  42  68
    //66  81  96  167
    //102 126 150 266

    @Test
    void multiplication() {
        Matrix result = testMatrix.multiplication(secondMatrix);
        int[][] expectedMatrix = {{30, 36, 42, 68}, {66, 81, 96, 167}, {102, 126, 150, 266}};
        assertArrayEquals(expectedMatrix, result.getMatrix());
    }

    @Test
    void multiplication_incorrectMatricies() {
        Matrix incorrectMatrix = new Matrix(4,3);
        incorrectMatrix.setElement(1,0,0);
        incorrectMatrix.setElement(2, 0, 1);
        incorrectMatrix.setElement(3, 0, 2);
        incorrectMatrix.setElement(4, 1, 0);
        incorrectMatrix.setElement(5, 1, 1);
        incorrectMatrix.setElement(6, 1, 2);
        incorrectMatrix.setElement(7, 2, 0);
        incorrectMatrix.setElement(8, 2, 1);
        incorrectMatrix.setElement(9, 2, 2);
        incorrectMatrix.setElement(10, 3, 0);
        incorrectMatrix.setElement(11, 3, 1);
        incorrectMatrix.setElement(12, 3, 2);

        Throwable throwable = assertThrows(RuntimeException.class, ()->{
            testMatrix.multiplication(incorrectMatrix);
        });

        assertEquals("Columns amount of matrix A should be equals amount of rows of matrix B", throwable.getMessage());
    }

    @Test
    void getRowNum() {
        assertEquals(3, testMatrix.getRowNum());
    }

    @Test
    void getColNum() {
        assertEquals(3, testMatrix.getColNum());
    }

    @Test
    void getElement() {
        assertEquals(3, testMatrix.getElement(0, 2));
    }

    @Test
    void getMatrix() {
        int[][] expectedMatrix = testMatrix.getMatrix();

        assertEquals(expectedMatrix, testMatrix.getMatrix());
    }
}