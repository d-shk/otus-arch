package ru.dmsh.otus.matrix.reader.impl;

import ru.dmsh.otus.matrix.model.Matrix;
import ru.dmsh.otus.matrix.reader.MatrixParser;

import java.util.ArrayList;
import java.util.List;

public class MatrixParserImpl implements MatrixParser {

    @Override
    public List<Matrix> parse(String initialMatricesStrings, String separator) {
        String[] matrices = initialMatricesStrings.split(separator);

        List<Matrix> resultMatrices = new ArrayList<>();

        for (String matrix : matrices) {
            Matrix m = extractMatrix(matrix.split("\n"));
            resultMatrices.add(m);
        }

        return resultMatrices;
    }

    private Matrix extractMatrix(String[] lines) {

        int i = 0;
        int j = 0;

        Matrix m = new Matrix(lines.length, lines[0].split(" ").length);
        for (String line : lines) {
            String[] symbols = line.split(" ");
            for (String s : symbols) {
                int element = Integer.parseInt(s);
                m.setElement(element, i, j);
                j++;
            }
            i++;
            j = 0;
        }
        return m;
    }
}
