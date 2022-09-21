package cyberwirtzlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int getFirstColumnSize() {
        return matrix[0].length;
    }

    public List<Integer> getAllColumnSizes() {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            ret.add(matrix[i].length);
        }
        return ret;
    }

    public Matrix transpose() {
        double[][] ret = new double[this.getFirstColumnSize()][this.getRowSize()];
        for (int column = 0; column < getFirstColumnSize(); column++) {
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
