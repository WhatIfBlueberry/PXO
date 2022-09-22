package com.wib.cyberwirtzlib.cyberwirtzimpl;

import com.wib.cyberwirtzlib.math.ComplexMatrix;
import com.wib.cyberwirtzlib.math.ComplexNumber;
import com.wib.cyberwirtzlib.math.iMatrix;

import java.util.Arrays;

public class ComplexCyberWirtz extends CyberWirtz {

    @Override
    public iMatrix add(iMatrix m1, iMatrix m2, iMatrix... args) {
        validateAddition(m1, m2);
        ComplexMatrix mat1 = ((ComplexMatrix) m1);
        ComplexMatrix mat2 = ((ComplexMatrix) m2);
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        ComplexNumber[][] ret = new ComplexNumber[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ret[row][column] = mat1.manipulate(row, column).addComp(mat2.manipulate(row, column));
            }
        }
        boolean argumentsLeft = args.length > 0;
        if (argumentsLeft) {
            return add(new ComplexMatrix(ret), args[0], Arrays.copyOfRange(args, 1, args.length));
        }
        return new ComplexMatrix(ret);
    }

    @Override
    public iMatrix multiply(iMatrix m1, iMatrix m2, iMatrix... args) {
        validateMultiplication(m1, m2);
        ComplexMatrix mat1 = ((ComplexMatrix) m1);
        ComplexMatrix mat2 = ((ComplexMatrix) m2);
        int rowSize = mat1.getRowSize();
        int columnSize1 = mat1.getFirstColumnSize();
        int columnSize2 = mat2.getFirstColumnSize();
        ComplexNumber[][] ret = initArray(rowSize, columnSize2);
        for (int row = 0; row < rowSize; row++) {
            for (int column2 = 0; column2 < columnSize2; column2++) {
                for (int column1 = 0; column1 < columnSize1; column1++) {
                    ret[row][column2] = ret[row][column2].addComp(mat1.manipulate(row, column1).multiplyComp(mat2.manipulate(column1, column2)));
                }
            }
        }
        boolean argumentsLeft = args.length > 0;
        if (argumentsLeft) {
            return multiply(new ComplexMatrix(ret), args[0], Arrays.copyOfRange(args, 1, args.length));
        }
        return new ComplexMatrix(ret);
    }

    @Override
    public iMatrix multiply(double scalar, iMatrix m1) {
        ComplexMatrix mat1 = ((ComplexMatrix) m1);
        ComplexNumber scal = new ComplexNumber(scalar, 0);
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        ComplexNumber[][] ret = initArray(rowSize, columnSize);
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ret[row][column] = mat1.manipulate(row, column).multiplyComp(scal);
            }
        }
        return new ComplexMatrix(ret);
    }

    public iMatrix multiply(ComplexNumber scalar, iMatrix m1) {
        ComplexMatrix mat1 = ((ComplexMatrix) m1);
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        ComplexNumber[][] ret = initArray(rowSize, columnSize);
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ret[row][column] = mat1.manipulate(row, column).multiplyComp(scalar);
            }
        }
        return new ComplexMatrix(ret);
    }


    @Override
    public ComplexNumber calculateExpectedValue(iMatrix mat, iMatrix vector) {
        return null; //multiply(vector.transpose(), mat, vector);
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
        if (!(m1 instanceof ComplexMatrix) || !(m2 instanceof ComplexMatrix)) {
            throw new IllegalArgumentException("Invalid Matrices! Check if iMatrix is instance of Matrix");
        }
    }

    private ComplexNumber[][] initArray(int rowSize, int colSize) {
        ComplexNumber[][] ret = new ComplexNumber[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                ret[i][j] = new ComplexNumber(0, 0);
            }
        }
        return ret;
    }
}
