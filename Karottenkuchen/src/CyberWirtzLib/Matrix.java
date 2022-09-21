package CyberWirtzLib;

public class Matrix {
    double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public int getRowSize() { return matrix.length; }
    public int getColumnSize() { return matrix[0].length; }

    public double[][] transpose() {
        return null;
    }
}
