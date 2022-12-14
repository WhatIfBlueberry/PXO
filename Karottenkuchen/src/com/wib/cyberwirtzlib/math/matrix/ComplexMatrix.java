package com.wib.cyberwirtzlib.math.matrix;

import com.wib.cyberwirtzlib.math.ComplexNumber;

import java.util.ArrayList;
import java.util.List;

public class ComplexMatrix implements iMatrix {
    ComplexNumber[][] matrix;

    public ComplexMatrix(ComplexNumber[][] matrix) {
        this.matrix = matrix;
    }

    public ComplexMatrix(int row, int col, boolean rand) {
        super();
        if (rand) {
            fillMatrixRandom(row, col);
        }
    }

    public ComplexMatrix(int row, int col) {
        this.matrix = new ComplexNumber[row][col];
        fillMatrixZeroes(row, col);
    }

    private void fillMatrixRandom(int rowInput, int colInput) {
        this.matrix = new ComplexNumber[rowInput][colInput];
        for (int row = 0; row < rowInput; row++) {
            for (int col = 0; col < colInput; col++) {
                this.matrix[row][col] = new ComplexNumber(Math.random(), Math.random());
            }
        }
    }

    private void fillMatrixZeroes(int rowInput, int colInput) {
        this.matrix = new ComplexNumber[rowInput][colInput];
        for (int row = 0; row < rowInput; row++) {
            for (int col = 0; col < colInput; col++) {
                this.matrix[row][col] = new ComplexNumber(0.0,0.0);
            }
        }
    }

    @Override
    public ComplexMatrix transpose() {
        ComplexNumber[][] ret = new ComplexNumber[this.getFirstColumnSize()][this.getRowSize()];
        for (int column = 0; column < getFirstColumnSize(); column++) {
            for (int row = 0; row < getRowSize(); row++) {
                ret[column][row] = this.matrix[row][column];
            }
        }
        return new ComplexMatrix(ret);
    }

    @Override
    public ComplexNumber getCell(int row, int column) {
        return this.matrix[row][column];
    }

    @Override
    public ComplexNumber[][] getArray() {
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
