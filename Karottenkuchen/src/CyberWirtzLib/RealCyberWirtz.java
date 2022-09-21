package CyberWirtzLib;

public class RealCyberWirtz extends CyberWirtz{

    @Override
    public Matrix add(Matrix mat1, Matrix mat2, Matrix... args) {
        return null;
    }

    @Override
    public Matrix multiply(Matrix mat1, Matrix mat2, Matrix... args) {
        return null;
    }

    @Override
    public Matrix calculateExpectedValue(Matrix mat, Matrix vector) {
        return multiply(vector.transpose(), mat, vector);
    }
}
