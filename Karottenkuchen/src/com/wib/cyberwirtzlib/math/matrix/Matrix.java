package com.wib.cyberwirtzlib.math.matrix;

import java.util.ArrayList;
import java.util.List;

public class Matrix implements iMatrix {
    Double[][] matrix;

    public Matrix(Double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(int row, int col, boolean rand) {
        super();
        if (rand) {
            fillMatrixRandom(row, col);
        }
    }

    public Matrix(int row, int col) {
        this.matrix = new Double[row][col];
        fillMatrixZeroes(row, col);
    }

    private void fillMatrixRandom(int rowInput, int colInput) {
        this.matrix = new Double[rowInput][colInput];
        for (int row = 0; row < rowInput; row++) {
            for (int col = 0; col < colInput; col++) {
                this.matrix[row][col] = Math.random();
            }
        }
    }

    private void fillMatrixZeroes(int rowInput, int colInput) {
        this.matrix = new Double[rowInput][colInput];
        for (int row = 0; row < rowInput; row++) {
            for (int col = 0; col < colInput; col++) {
                this.matrix[row][col] = 0.0;
            }
        }
    }

    @Override
    public Double getCell(int row, int column) {
        return this.matrix[row][column];
    }

    @Override
    public Double[][] getArray() {
        return this.matrix;
    }

    @Override
    public int getRowSize() {
        return matrix.length;
    }

    @Override
    public int getFirstColumnSize() {
        return matrix[0].length;
    }

    @Override
    public List<Integer> getAllColumnSizes() {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            ret.add(matrix[i].length);
        }
        return ret;
    }

    @Override
    public Matrix transpose() {
        Double[][] ret = new Double[this.getFirstColumnSize()][this.getRowSize()];
        for (int column = 0; column < getFirstColumnSize(); column++) {
            for (int row = 0; row < getRowSize(); row++) {
                ret[column][row] = this.matrix[row][column];
            }
        }
        return new Matrix(ret);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out = out.append("[");
        for (int row = 0; row < getRowSize(); row++) {
            for (int column = 0; column < getFirstColumnSize(); column++) {
                out.append(matrix[row][column]);
                out.append(column != getFirstColumnSize() - 1 ? ", " : ";");
            }
            out.append(row != getRowSize() - 1 ? "\n" : "");
        }
        out.append("]");
        return out.toString();
    }
}
