package cyberwirtzlib;

import cyberwirtzlib.math.Matrix;

/**
 * In memory of Prof. Dr. Wirtz LA1
 * {@link #add(Matrix, Matrix, Matrix...) adding matrices}
 * {@link #multiply(Matrix, Matrix, Matrix...) multiplying matrices}
 * {@link #calculateExpectedValue(Matrix, Matrix) calculating the expected value}
 */
public abstract class CyberWirtz {

    /**
     * allows to add any number of Matrices. First two to are added normally, all the others via recursion.
     * @param mat1 First Matrix
     * @param mat2 Second Matrix
     * @param args Additional Matrices
     * @return
     * returns Sum of all matrices
     */

    public abstract Matrix add(Matrix mat1, Matrix mat2, Matrix... args);

    /**
     * allows to multiply any number of Matrices. First two to are multiplied normally, all the others via recursion.
     * @param mat1 First Matrix
     * @param mat2 Second Matrix
     * @param args Additional Matrices
     * @return
     * returns product of all matrices in order
     */
    public abstract Matrix multiply(Matrix mat1, Matrix mat2, Matrix... args);

    /**
     * @param mat First Matrix
     * @param vector Second Vector
     * @return returns expected value as scalar. Applies V'MV
     */
    public Matrix calculateExpectedValue(Matrix mat, Matrix vector) {
        return multiply(vector.transpose(), mat, vector);
    }

    /**
     * checks row and column size. To be able to add them, both need to be equal.
     * @param mat1
     * @param mat2
     */
    protected boolean matricesCanBeAdded(Matrix mat1, Matrix mat2) {
        boolean validRowSize = mat1.getRowSize() == mat2.getRowSize();
        boolean validColumnSize = mat1.getAllColumnSizes().equals(mat2.getAllColumnSizes());
        return validRowSize && validColumnSize;
    }

    protected boolean matricesCanBeMultiplied(Matrix mat1, Matrix mat2) {
        boolean rowAndColumnHaveValidDimension = mat1.getRowSize() == mat2.getFirstColumnSize();
        boolean columnAndRowHaveValidDimension = mat1.getFirstColumnSize() == mat2.getRowSize();
        return rowAndColumnHaveValidDimension || columnAndRowHaveValidDimension;
    }
}
