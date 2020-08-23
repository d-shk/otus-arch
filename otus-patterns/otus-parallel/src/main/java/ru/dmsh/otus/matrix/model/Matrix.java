package ru.dmsh.otus.matrix.model;

public class Matrix {
    private final int rowNum;
    private final int colNum;

    private final int[][] matrix;

    public Matrix(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.matrix = new int[rowNum][colNum];
    }

    public void setElement(int value, int row, int col) {
        matrix[row][col] = value;
    }

    public Matrix multiplication(Matrix second) {
        if(getColNum()!=second.getRowNum()) {
            throw new RuntimeException("Columns amount of matrix A should be equals amount of rows of matrix B");
        }

        Matrix result = new Matrix(getRowNum(), second.getColNum());

        for(int i = 0; i<getRowNum(); i++)
            for(int j=0; j<second.getColNum(); j++) {
                result.setElement(calculateVal(second, i, j), i, j);
            }

        return result;
    }


    private int calculateVal(Matrix second, int i, int j) {
        int val = 0;
        for (int k = 0; k < getColNum(); k++) {
            val+= getElement(i, k) * second.getElement(k, j);
        }
        return val;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public int getElement(int row, int col) {
        return matrix[row][col];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < getRowNum(); i++) {
            for (int j = 0; j < getColNum(); j++) {
                res.append(getElement(i, j)).append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }
}
