package com.wib.cyberwirtzlib;

import com.wib.cyberwirtzlib.math.Matrix;
import com.wib.cyberwirtzlib.math.iMatrix;

import java.util.Arrays;

public class RealCyberWirtz extends CyberWirtz {

    @Override
    public iMatrix add(iMatrix m1, iMatrix m2, iMatrix... args) {
        Matrix mat1 = ((Matrix) m1);
        Matrix mat2 = ((Matrix) m2);
        if (!matricesCanBeAdded(m1, m2)) {
            throw new IllegalArgumentException("Invalid Matrices! Check dimensions.");
        }
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        Double[][] ret = new Double[rowSize][columnSize];
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
    public iMatrix multiply(iMatrix m1, iMatrix m2, iMatrix... args) {
        return null;
    }
}
