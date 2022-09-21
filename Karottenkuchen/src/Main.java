import com.wib.cyberwirtzlib.CyberWirtz;
import com.wib.cyberwirtzlib.CyberWirtzFactory;
import com.wib.cyberwirtzlib.math.ComplexMatrix;
import com.wib.cyberwirtzlib.math.ComplexNumber;
import com.wib.cyberwirtzlib.math.Fields;
import com.wib.cyberwirtzlib.math.Matrix;


public class Main {
    public static void main(String[] args) {
        CyberWirtzFactory factory = new CyberWirtzFactory();
        CyberWirtz wirtz = factory.generate(Fields.REAL);
        double[][] a = {{1, 2, 3, 4}, {5, 6, 7, 7}};
        double[][] b = {{1, 2, 3, 4}, {5, 6, 7}};
        double[][] c = {{1, 2, 3, 4}, {5, 6, 3, 7}};
        double[][] d = {{1, 2, 2, 4}, {5, 4, 7, 1}};
        double[][] f = {{1, 3, 2, 4}, {5, 4, 7, 1}};
        ComplexNumber c1 = new ComplexNumber(1,2);
        ComplexNumber c2 = new ComplexNumber(3,4);
        ComplexNumber c3 = new ComplexNumber(4,2);
        ComplexNumber c4 = new ComplexNumber(1,1);
        ComplexNumber[][] matrix = new ComplexNumber[][]{{c1,c2}, {c3,c4}};
        ComplexMatrix matrix2 = new ComplexMatrix(matrix);
        System.out.println(matrix2);
    }
}