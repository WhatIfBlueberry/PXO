package com.wib.cyberwirtzlib.cyberwirtzimpl;

import com.wib.cyberwirtzlib.math.matrix.ComplexMatrix;
import com.wib.cyberwirtzlib.math.ComplexNumber;
import com.wib.cyberwirtzlib.math.matrix.iMatrix;

import java.util.Arrays;

public class ComplexCyberWirtz extends CyberWirtz {

    @Override
    public ComplexMatrix add(iMatrix m1, iMatrix m2, iMatrix... args) {
        validateAddition(m1, m2);
        ComplexMatrix mat1 = ((ComplexMatrix) m1);
        ComplexMatrix mat2 = ((ComplexMatrix) m2);
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        ComplexNumber[][] ret = new ComplexNumber[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ret[row][column] = mat1.getCell(row, column).addComp(mat2.getCell(row, column));
            }
        }
        boolean argumentsLeft = args.length > 0;
        if (argumentsLeft) {
            return add(new ComplexMatrix(ret), args[0], Arrays.copyOfRange(args, 1, args.length));
        }
        return new ComplexMatrix(ret);
    }

    @Override
    public ComplexMatrix multiply(iMatrix m1, iMatrix m2, iMatrix... args) {
        validateMultiplication(m1, m2);
        ComplexMatrix mat1 = ((ComplexMatrix) m1);
        ComplexMatrix mat2 = ((ComplexMatrix) m2);
        int rowSize = mat1.getRowSize();
        int columnSize1 = mat1.getFirstColumnSize();
        int columnSize2 = mat2.getFirstColumnSize();
        ComplexNumber[][] ret = new ComplexMatrix(rowSize, columnSize2).getArray();
        for (int row = 0; row < rowSize; row++) {
            for (int column2 = 0; column2 < columnSize2; column2++) {
                for (int column1 = 0; column1 < columnSize1; column1++) {
                    ret[row][column2] = ret[row][column2].addComp(mat1.getCell(row, column1).multiplyComp(mat2.getCell(column1, column2)));
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
    public ComplexMatrix multiply(double scalar, iMatrix m1) {
        ComplexMatrix mat1 = ((ComplexMatrix) m1);
        ComplexNumber scal = new ComplexNumber(scalar, 0);
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        ComplexNumber[][] ret = new ComplexMatrix(rowSize,columnSize).getArray();
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ret[row][column] = mat1.getCell(row, column).multiplyComp(scal);
            }
        }
        return new ComplexMatrix(ret);
    }

    public ComplexMatrix multiply(ComplexNumber scalar, iMatrix m1) {
        ComplexMatrix mat1 = ((ComplexMatrix) m1);
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        ComplexNumber[][] ret = new ComplexMatrix(rowSize,columnSize).getArray();
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ret[row][column] = mat1.getCell(row, column).multiplyComp(scalar);
            }
        }
        return new ComplexMatrix(ret);
    }

    @Override
    public ComplexNumber calculateExpectedValue(iMatrix mat, iMatrix vector) {
        validateExpected(mat, vector);
        ComplexMatrix mat1 = ((ComplexMatrix) mat);
        ComplexMatrix vec = ((ComplexMatrix) vector);
        ComplexMatrix matrix = multiply(vec.transpose(), mat1, vec);
        return matrix.getCell(0,0);
    }

    @Override
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
        if (!(m1 instanceof ComplexMatrix) || !(m2 instanceof ComplexMatrix)) {
            throw new IllegalArgumentException("Invalid Matrices! Check if iMatrix is instance of Matrix");
        }
    }
}
