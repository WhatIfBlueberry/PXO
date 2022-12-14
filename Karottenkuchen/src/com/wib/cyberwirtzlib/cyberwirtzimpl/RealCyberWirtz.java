package com.wib.cyberwirtzlib.cyberwirtzimpl;

import com.wib.cyberwirtzlib.math.matrix.ComplexMatrix;
import com.wib.cyberwirtzlib.math.matrix.Matrix;
import com.wib.cyberwirtzlib.math.matrix.iMatrix;

import java.util.Arrays;

public class RealCyberWirtz extends CyberWirtz {

    @Override
    public Matrix add(iMatrix m1, iMatrix m2, iMatrix... args) {
        validateAddition(m1, m2);
        Matrix mat1 = ((Matrix) m1);
        Matrix mat2 = ((Matrix) m2);
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        Double[][] ret = new Double[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ret[row][column] = mat1.getCell(row, column) + mat2.getCell(row, column);
            }
        }
        boolean argumentsLeft = args.length > 0;
        if (argumentsLeft) {
            return add(new Matrix(ret), args[0], Arrays.copyOfRange(args, 1, args.length));
        }
        return new Matrix(ret);
    }

    @Override
    public Matrix multiply(iMatrix m1, iMatrix m2, iMatrix... args) {
        validateMultiplication(m1, m2);
        Matrix mat1 = ((Matrix) m1);
        Matrix mat2 = ((Matrix) m2);
        Double[][] ret = new Matrix(mat1.getRowSize(), mat2.getFirstColumnSize()).getArray();
        for (int i = 0; i < mat1.getRowSize(); i++) {
            for (int j = 0; j < mat2.getFirstColumnSize(); j++) {
                for (int k = 0; k < mat1.getFirstColumnSize(); k++) {
                    double value = mat1.getCell(i, k) * mat2.getCell(k, j);
                    ret[i][j] += (double)Math.round(value * 100000d) / 100000d;
                }
            }
        }
        boolean argumentsLeft = args.length > 0;
        if (argumentsLeft) {
            return multiply(new Matrix(ret), args[0], Arrays.copyOfRange(args, 1, args.length));
        }
        return new Matrix(ret);
    }

    @Override
    public Matrix multiply(double scalar, iMatrix m1) {
        Matrix mat1 = ((Matrix) m1);
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        Double[][] ret = new Matrix(rowSize, columnSize).getArray();
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                double value = mat1.getCell(row, column) * scalar;
                ret[row][column] = (double)Math.round(value * 100000d) / 100000d;
            }
        }
        return new Matrix(ret);
    }

    @Override
    public Double calculateExpectedValue(iMatrix mat, iMatrix vector) {
        validateExpected(mat, vector);
        Matrix mat1 = ((Matrix) mat);
        Matrix vec = ((Matrix) vector);
        Matrix matrix = multiply(vec.transpose(), mat1, vec);
        return matrix.getCell(0,0);
    }

    protected void validateExpected(iMatrix mat, iMatrix vector) {
        checkInstance(mat, vector);
        if (!matricesCanBeMultiplied(mat, vector)) {
            throw new IllegalArgumentException("Invalid Matrices! Check dimensions.");
        }
        if (mat.getRowSize() != mat.getFirstColumnSize()) {
            throw new IllegalArgumentException("Matrix has to be quadratic");
        }
    }

    @Override
    protected void validateAddition(iMatrix m1, iMatrix m2) {
        checkInstance(m1, m2);
        if (!matricesCanBeAdded(m1, m2)) {
            throw new IllegalArgumentException("Invalid Matrices! Check dimensions.");
        }
    }

    @Override
    protected void validateMultiplication(iMatrix m1, iMatrix m2) {
        checkInstance(m1, m2);
        if (!matricesCanBeMultiplied(m1, m2)) {
            throw new IllegalArgumentException("Invalid Matrices! Check dimensions.");
        }
    }

    @Override
    protected void checkInstance(iMatrix m1, iMatrix m2) {
        if (!(m1 instanceof Matrix) || !(m2 instanceof Matrix)) {
            throw new IllegalArgumentException("Invalid Matrices! Check if iMatrix is instance of Matrix");
        }
    }
}
