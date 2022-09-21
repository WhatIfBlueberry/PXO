package CyberWirtzLib;

public class RealCyberWirtz extends CyberWirtz {

    @Override
    public Matrix add(Matrix mat1, Matrix mat2, Matrix... args) {
        boolean invalidRowSize = mat1.getRowSize() != mat2.getRowSize();
        boolean invalidColumnSize = mat1.getColumnSize() != mat2.getColumnSize();
        if (invalidRowSize || invalidColumnSize) {
            System.out.println("du bist doof! Falsche Matrizzen");
            //throw new IllegalAccessException("Matrices have inproper dimensions");
        }
        int rowSize = mat1.getRowSize();
        int columnSize = mat1.getColumnSize();
        double[][] ret = new double[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                ret[i][j] = mat1.manipulate(i, j) + mat2.manipulate(i, j);
            }
        }
        return new Matrix(ret);
    }

    @Override
    public Matrix multiply(Matrix mat1, Matrix mat2, Matrix... args) {
        return null;
    }
}
