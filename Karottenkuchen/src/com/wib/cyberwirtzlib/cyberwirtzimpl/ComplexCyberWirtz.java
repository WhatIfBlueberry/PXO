package com.wib.cyberwirtzlib.cyberwirtzimpl;

import com.wib.cyberwirtzlib.math.ComplexMatrix;
import com.wib.cyberwirtzlib.math.ComplexNumber;
import com.wib.cyberwirtzlib.math.iMatrix;

import java.util.Arrays;

public class ComplexCyberWirtz extends CyberWirtz {

    @Override
    public iMatrix add(iMatrix m1, iMatrix m2, iMatrix... args) {
        ComplexMatrix mat1 = ((ComplexMatrix) m1);
        ComplexMatrix mat2 = ((ComplexMatrix) m2);
        if (!matricesCanBeAdded(m1, m2)) {
            throw new IllegalArgumentException("Invalid Matrices! Check dimensions.");
        }
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getFirstColumnSize();
        ComplexNumber[][] ret = new ComplexNumber[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                ret[row][column] = mat1.manipulate(row, column).addComp(mat2.manipulate(row, column));
            }
        }
        boolean argumentsLeft = args.length > 0;
        if (argumentsLeft) {
            return add(new ComplexMatrix(ret), args[0], Arrays.copyOfRange(args, 1, args.length));
        }
        return new ComplexMatrix(ret);
    }

    @Override
    public iMatrix multiply(iMatrix m1, iMatrix m2, iMatrix... args) {
        return null;
    }

    @Override
    public iMatrix multiply(int scalar, iMatrix m1) {
        return null;
    }
}
