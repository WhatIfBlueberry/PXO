package com.wib.cyberwirtzlib.cyberwirtzimpl;

import com.wib.cyberwirtzlib.math.iMatrix;

/**
 * In memory of Prof. Dr. Wirtz LA1
 * {@link #add(iMatrix, iMatrix, iMatrix...) adding matrices}
 * {@link #multiply(iMatrix, iMatrix, iMatrix...) multiplying matrices}
 * {@link #calculateExpectedValue(iMatrix, iMatrix) calculating the expected value}
 */
public abstract class CyberWirtz {

    /**
     * allows to add any number of Matrices. First two to are added normally, all the others via recursion.
     *
     * @param m1   First Matrix
     * @param m2   Second Matrix
     * @param args Additional Matrices
     * @return returns Sum of all matrices
     */

    public abstract iMatrix add(iMatrix m1, iMatrix m2, iMatrix... args);

    /**
     * allows to multiply any number of Matrices. First two to are multiplied normally, all the others via recursion.
     *
     * @param m1   First Matrix
     * @param m2   Second Matrix
     * @param args Additional Matrices
     * @return returns product of all matrices in order
     */
    public abstract iMatrix multiply(iMatrix m1, iMatrix m2, iMatrix... args);

    /**
     * multiplies scalar with any iMatrix m1
     *
     * @param scalar
     * @param m1
     * @return
     */
    public abstract iMatrix multiply(int scalar, iMatrix m1);

    /**
     * @param mat    First Matrix
     * @param vector Second Vector
     * @return returns expected value as scalar. Applies V'MV
     */
    public abstract Object calculateExpectedValue(iMatrix mat, iMatrix vector);

    /**
     * throws exception if matrices are of wrong type or have invalid column / rows
     * @param m1
     * @param m2
     */
    protected abstract void validateAddition(iMatrix m1, iMatrix m2);

    /**
     * throws exception if matrices are of wrong type or have invalid column / rows
     * @param m1
     * @param m2
     */
    protected abstract void validateMultiplication(iMatrix m1, iMatrix m2);

    /**
     * checks if both matrices are of desired Type, throws Exception if not.
     * @param m1
     * @param m2
     * @return
     */
    protected abstract void checkInstance(iMatrix m1, iMatrix m2);

    /**
     * checks row and column size. To be able to add them, both need to be equal.
     *
     * @param m1
     * @param m2
     */
    protected boolean matricesCanBeAdded(iMatrix m1, iMatrix m2) {
        boolean validRowSize = m1.getRowSize() == m2.getRowSize();
        boolean validColumnSize = m1.getAllColumnSizes().equals(m2.getAllColumnSizes());
        return validRowSize && validColumnSize;
    }

    /**
     * checks row and column size. To be able to multiply, row / column or column / row need to match.
     *
     * @param m1
     * @param m2
     */
    protected boolean matricesCanBeMultiplied(iMatrix m1, iMatrix m2) {
        boolean rowAndColumnHaveValidDimension = m1.getRowSize() == m2.getFirstColumnSize();
        boolean columnAndRowHaveValidDimension = m1.getFirstColumnSize() == m2.getRowSize();
        return rowAndColumnHaveValidDimension && columnAndRowHaveValidDimension;
    }
}
