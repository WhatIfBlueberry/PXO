package cyberwirtzlib;

import java.util.Arrays;

public class Matrix {
    double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * @param row
     * @param column
     * @return return contents of matrix at row / column
     */
    public double manipulate(int row, int column) {
        return this.matrix[row][column];
    }

    public int getRowSize() {
        return matrix.length;
    }

    public int getColumnSize() {
        return matrix[0].length;
    }

    public Matrix transpose() {
        double[][] ret = new double[this.getColumnSize()][this.getRowSize()];
        for (int i = 0; i < getColumnSize(); i++) {
            for (int j = 0; j < getRowSize(); j++) {
                ret[i][j] = this.matrix[j][i];
            }
        }
        return new Matrix(ret);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.matrix);
    }
}
