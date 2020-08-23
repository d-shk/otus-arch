package ru.dmsh.otus.matrix.reader.impl;

import ru.dmsh.otus.matrix.model.Matrix;
import ru.dmsh.otus.matrix.reader.MatrixPrinter;

public class MatrixPrinterImpl implements MatrixPrinter {
    @Override
    public void print(Matrix matrix) {
        for (int i = 0; i < matrix.getRowNum(); i++) {
            for (int j = 0; j < matrix.getColNum(); j++) {
                System.out.print(matrix.getElement(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println("-----");
    }
}
