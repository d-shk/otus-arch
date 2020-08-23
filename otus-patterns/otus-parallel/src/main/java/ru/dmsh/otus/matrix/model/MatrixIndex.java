package ru.dmsh.otus.matrix.model;

public class MatrixIndex {
    private final int row;
    private final int col;

    public MatrixIndex(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }


    @Override
    public String toString() {
        return "MatrixIndex " + row +
                " " + col +";";
    }
}
