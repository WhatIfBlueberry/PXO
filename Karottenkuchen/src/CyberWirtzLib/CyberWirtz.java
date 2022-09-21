package CyberWirtzLib;

public abstract class CyberWirtz {

    public abstract Matrix add(Matrix mat1, Matrix mat2, Matrix... args);

    /**
     *
     * @param mat1 First Matrix
     * @param mat2 Second Matrix
     * @param args Additional Matrices
     * @return
     * returns product of all of them
     */
    public abstract Matrix multiply(Matrix mat1, Matrix mat2, Matrix... args);

    public Matrix calculateExpectedValue(Matrix mat, Matrix vector) {
        return multiply(vector.transpose(), mat, vector);
    }
}
