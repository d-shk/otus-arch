package ru.dmsh.otus.matrix.reader;

import ru.dmsh.otus.matrix.model.Matrix;

import java.util.List;

public interface MatrixParser {
    List<Matrix> parse(String matrix, String separator);
}
