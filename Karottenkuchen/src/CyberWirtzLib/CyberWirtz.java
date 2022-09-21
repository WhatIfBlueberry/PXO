package CyberWirtzLib;

public abstract class CyberWirtz {
    public abstract Matrix multiply(Matrix mat1, Matrix mat2, Matrix... args);
    public abstract Matrix calculateExpectedValue(Matrix mat, Matrix vector);
}
