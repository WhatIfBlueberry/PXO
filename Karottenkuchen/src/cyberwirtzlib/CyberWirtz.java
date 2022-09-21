package cyberwirtzlib;

import java.util.List;

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

    protected boolean matricesCanBeAdded(Matrix mat1, Matrix mat2) {
        boolean invalidRowSize = mat1.getRowSize() != mat2.getRowSize();
        boolean invalidColumnSize = !mat1.getAllColumnSizes().equals(mat2.getAllColumnSizes());
        if (invalidRowSize || invalidColumnSize) {
            return false;
        }
        return true;
    }
}
