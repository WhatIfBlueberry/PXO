package CyberWirtzLib;

/**
 * {@link #add(Matrix, Matrix, Matrix...) adding matrices}
 * {@link #multiply(Matrix, Matrix, Matrix...) multiplying matrices}
 * {@link #calculateExpectedValue(Matrix, Matrix) calculating the expected value}
 */
public abstract class CyberWirtz {

    /**
     * @param mat1 First Matrix
     * @param mat2 Second Matrix
     * @param args Additional Matrices
     * @return
     * returns Sum of all matrices
     */

    public abstract Matrix add(Matrix mat1, Matrix mat2, Matrix... args);

    /**
     * @param mat1 First Matrix
     * @param mat2 Second Matrix
     * @param args Additional Matrices
     * @return
     * returns product of all matrices in order
     */
    public abstract Matrix multiply(Matrix mat1, Matrix mat2, Matrix... args);

    public Matrix calculateExpectedValue(Matrix mat, Matrix vector) {
        return multiply(vector.transpose(), mat, vector);
    }

    protected boolean matricesCanBeAdded(Matrix mat1, Matrix mat2) {
        boolean invalidRowSize = mat1.getRowSize() != mat2.getRowSize();
        boolean invalidColumnSize = mat1.getColumnSize() != mat2.getColumnSize();
        if (invalidRowSize || invalidColumnSize) {
            return false;
        }
        return true;
    }
}
