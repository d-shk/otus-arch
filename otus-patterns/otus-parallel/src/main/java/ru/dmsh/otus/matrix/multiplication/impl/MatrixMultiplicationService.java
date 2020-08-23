package ru.dmsh.otus.matrix.multiplication.impl;

import ru.dmsh.otus.matrix.model.Matrix;
import ru.dmsh.otus.matrix.multiplication.IMatrixMultiplicationService;

public class MatrixMultiplicationService implements IMatrixMultiplicationService {

    private final Matrix firstMatrix, secondMatrix;

    public MatrixMultiplicationService(final Matrix firstMatrix, final Matrix secondMatrix) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
    }

    @Override
    public Matrix calculate() {
        return firstMatrix.multiplication(secondMatrix);
    }
}
