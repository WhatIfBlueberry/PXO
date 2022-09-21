package CyberWirtzLib;

public class Matrix {
    double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public int getRowSize() { return matrix.length; }
    public int getColumnSize() { return matrix[0].length; }

    public Matrix transpose() {
        double[][] ret = new double[this.getColumnSize()][this.getRowSize()];
        for (int i = 0; i < getColumnSize(); i++) {
            for (int j = 0; j < getRowSize(); j++) {
                ret[i][j] = this.matrix[j][i];
            }
        }
        return new Matrix(ret);
    }
}
