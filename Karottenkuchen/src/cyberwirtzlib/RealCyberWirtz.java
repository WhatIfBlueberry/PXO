package cyberwirtzlib;

import java.util.Arrays;

public class RealCyberWirtz extends CyberWirtz {

    @Override
    public Matrix add(Matrix mat1, Matrix mat2, Matrix... args) {
        if (!matricesCanBeAdded(mat1, mat2)) {
            throw new IllegalArgumentException("Invalid Matrices! Check dimensions.");
        }
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getColumnSize();
        double[][] ret = new double[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ret[row][column] = mat1.manipulate(row, column) + mat2.manipulate(row, column);
            }
        }
        boolean argumentsLeft = args.length > 0;
        if (argumentsLeft) {
            return add(new Matrix(ret), args[0], Arrays.copyOfRange(args, 1, args.length));
        }
        return new Matrix(ret);
    }

    @Override
    public Matrix multiply(Matrix mat1, Matrix mat2, Matrix... args) {
        return null;
    }
}
