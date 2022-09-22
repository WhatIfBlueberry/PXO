package com.wib.cyberwirtzlib.cyberwirtzimpl;

import com.wib.cyberwirtzlib.math.ComplexMatrix;
import com.wib.cyberwirtzlib.math.ComplexNumber;
import com.wib.cyberwirtzlib.math.Matrix;
import com.wib.cyberwirtzlib.math.iMatrix;

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
                ret[row][column] = mat1.manipulate(row, column) + mat2.manipulate(row, column);
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
        Matrix mat1 = ((Matrix) m1);
        Matrix mat2 = ((Matrix) m2);
        if (!matricesCanBeMultiplied(mat1, mat2)) {
            throw new IllegalArgumentException("Invalid Matrices! Check dimensions.");
        }
        Double[][] ret = initArray(mat1.getRowSize(), mat2.getFirstColumnSize());
        for (int i = 0; i < mat1.getRowSize(); i++) {
            for (int j = 0; j < mat2.getFirstColumnSize(); j++) {
                for (int k = 0; k < mat1.getFirstColumnSize(); k++) {
                    ret[i][j] += mat1.manipulate(i, k) * mat2.manipulate(k, j);
                }
            }
        }
        return new Matrix(ret);
    }

    @Override
    public Matrix multiply(double scalar, iMatrix m1) {
        Matrix mat1 = ((Matrix) m1);
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        Double[][] ret = initArray(rowSize, columnSize);
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ret[row][column] = mat1.manipulate(row, column) * scalar;
            }
        }
        return new Matrix(ret);
    }

    @Override
    public Double calculateExpectedValue(iMatrix mat, iMatrix vector) {
        return null;//multiply(vector.transpose(), mat, vector);
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

    private Double[][] initArray(int rowSize, int colSize) {
        Double[][] ret = new Double[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                ret[i][j] = 0.0;
            }
        }
        return ret;
    }
}