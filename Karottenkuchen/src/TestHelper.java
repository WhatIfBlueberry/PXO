import com.wib.cyberwirtzlib.cyberwirtzimpl.ComplexCyberWirtz;
import com.wib.cyberwirtzlib.cyberwirtzimpl.CyberWirtz;
import com.wib.cyberwirtzlib.cyberwirtzimpl.RealCyberWirtz;
import com.wib.cyberwirtzlib.math.ComplexMatrix;
import com.wib.cyberwirtzlib.math.ComplexNumber;
import com.wib.cyberwirtzlib.math.Matrix;

public class TestHelper {

    private Double[][] a = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 7.0}};
    private Double[][] b = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 1.0}};
    private Double[][] c = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 3.0, 7.0}};
    private Double[][] d = {{1.0, 2.0, 2.0, 4.0}, {5.0, 4.0, 7.0, 1.0}};
    private Double[][] f = {{1.0, 3.0, 2.0, 4.0}, {5.0, 4.0, 7.0, 1.0}};

    private Matrix m1 = new Matrix(a);
    private Matrix m2 = new Matrix(b);
    private Matrix m3 = new Matrix(c);
    private Matrix m4 = new Matrix(d);
    private Matrix m5 = new Matrix(f);

    private ComplexNumber c1 = new ComplexNumber(1, 2);
    private ComplexNumber c2 = new ComplexNumber(3, 4);
    private ComplexNumber c3 = new ComplexNumber(4, 2);
    private ComplexNumber c4 = new ComplexNumber(1, 1);
    private ComplexNumber[][] matrix = new ComplexNumber[][]{{c1, c2}, {c3, c4}};
    private ComplexMatrix matrix2 = new ComplexMatrix(matrix);

    private CyberWirtz real = new RealCyberWirtz();
    private CyberWirtz complex = new ComplexCyberWirtz();

    public void addTwoMatrices() {
        try {
            real.add(m1, m2);
        } catch (Exception e) {
            System.out.println("Test failed");
        }
        System.out.println("Test OK");
    }

    public void addMultipleMatrices() {
        try {
            real.add(m1, m2, m3, m4, m5);
        } catch (Exception e) {
            System.out.println("Test failed");
        }
        System.out.println("Test OK");
    }

    public void addTwoComplexMatrices() {
        try {
            complex.add(matrix2, new ComplexMatrix(2, 2));
        } catch (Exception e) {
            System.out.println("Test failed");
        }
        System.out.println("Test OK");
    }

    public void addMultipleComplexMatrices() {
        try {
            complex.add(getRand(), getRand(), getRand(), getRand(), getRand());
        } catch (Exception e) {
            System.out.println("Test failed");
        }
        System.out.println("Test OK");
    }

    private ComplexMatrix getRand() {
        return new ComplexMatrix(2, 2);
    }

    public void testMultiply() {
        System.out.println(real.multiply(m1,m2));
    }


}
