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
        for (int column = 0; column < getColumnSize(); column++) {
            for (int row = 0; row < getRowSize(); row++) {
                ret[column][row] = this.matrix[row][column];
            }
        }
        return new Matrix(ret);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.matrix);
    }
}
